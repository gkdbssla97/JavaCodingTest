import java.util.*;
import java.util.stream.*;

class Solution {
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int row, col;
    public int solution(String[] board) {
        int answer = 0;
        row = board.length;
        col = board[0].length();
        map = new String[row][col];
        visited = new boolean[row][col];
        
        Node start = null;
        Node end = null;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i][j] = board[i].charAt(j) + "";
                // 시작점
                if(map[i][j].equals("R")) {
                    start = new Node(i, j, 0);
                    visited[i][j] = true;
                }
                // 도착점
                if(map[i][j].equals("G")) {
                    end = new Node(i, j, 0);
                }
            }
        }
        answer = func1(start, end);    
        print(start, end);
        return answer;
    }
    public int func1(Node start, Node end) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            Node p = q.poll();
            // 도착했는가?
            if(p.x == end.x && p.y == end.y) {
                return p.cnt;
            }
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if(0 <= nx && nx < row && 0 <= ny && ny < col
                  && !map[nx][ny].equals("D")) {
                    // 도착하지 않았을경우
                    while(0 <= nx && nx < row && 0 <= ny && ny < col
              && !map[nx][ny].equals("D")) {
                        nx = dx[i] + nx;
                        ny = dy[i] + ny;
                    }
                    // 뒤로 후진
                    nx = nx - dx[i];
                    ny = ny - dy[i];
                    // 도착했는가?
                    if(nx == end.x && ny == end.y) {
                        return p.cnt + 1;
                    }
                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, p.cnt + 1));
                    
                }
            }
        }
        return -1;
    }
    public class Node {
        int x, y, cnt;
        
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public void print(Node start, Node end) {
        System.out.println(start.x + " " + start.y);
        System.out.println(end.x + " " + end.y);
        for(int i = 0; i < row; i++) {
            Arrays.stream(map[i]).forEach(System.out::print);
            System.out.println();
        }
        System.out.println("---");
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(visited[i][j]);    
                
            }
            System.out.println();
        }
    }
}