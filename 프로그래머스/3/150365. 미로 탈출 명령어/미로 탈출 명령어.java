import java.util.*;
import java.util.stream.*;

class Solution {
    static String[][] board;
    // 하 좌 우 상 -> d l r u
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        board = new String[n][m];
        
        init(x, y, r, c);
        // print();
        
        // dfs(n, m, x - 1, y - 1, r - 1, c - 1, k);
        return dfs(n, m, x - 1, y - 1, r - 1, c - 1, k);
    }
    String dfs(int n, int m, int x, int y, int r, int c, int k) {
        // Queue<Node> q = new LinkedList<>();
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
            return o1.route.compareTo(o2.route);
        });
        q.offer(new Node(x, y, 0, new StringBuilder()));
        
        while(!q.isEmpty()) {
            Node p = q.poll();
            if(p.cnt == k){
                if(p.x == r && p.y == c) {
                    return p.route + "";
                } 
                continue;
            }
            if(manhattan(p.x, p.y, r, c) > k - p.route.length()) continue;
            if((k - p.route.length()) % 2 != manhattan(p.x, p.y, r, c) % 2) continue;
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                
                if(!isRange(nx, ny, n, m)) continue;
                StringBuilder dir;
                if(i == 0) {
                    // dir.append("d");
                     dir = new StringBuilder("d");
                } else if(i == 1) {
                    // dir.append("l");
                    dir = new StringBuilder("l");
                } else if(i == 2) {
                    // dir.append("r");
                    dir = new StringBuilder("r");
                } else {
                    // dir.append("u");
                    dir = new StringBuilder("u");
                }
                q.offer(new Node(nx, ny, p.cnt + 1, new StringBuilder(p.route).append(dir)));
                    
            }

        }
        
        return "impossible";
    }
    int manhattan(int x, int y, int a, int b) {
        return Math.abs(x - a) + Math.abs(y - b);
    }
    boolean isRange(int nx, int ny, int n, int m) {
        return 0 <= nx && nx < n && 0 <= ny && ny < m;
    }
    
    void init(int x, int y, int r, int c) {
        for(int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], ".");
            board[x - 1][y - 1] = "S";
            board[r - 1][c - 1] = "E";
        }
    }
    void print() {
        for(int i = 0; i < board.length; i++) {
            Arrays.stream(board[i]).forEach(x -> System.out.print(x));
            System.out.println();
        }
    }
    static class Node {
        int x, y, cnt;
        StringBuilder route;
        
        Node(int x, int y, int cnt, StringBuilder route) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.route = route;
        }
    }
}