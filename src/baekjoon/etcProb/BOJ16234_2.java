package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16234_2 {
    static int [][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, L ,R;
    static ArrayList<Point> open;
    static int cnt = 0;
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < s.length; j++) {
                board[i][j] = s[j];
            }
        }
        while(true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        open = new ArrayList<>();
                        open.add(new Point(i, j));
                        bfs(i, j);
                        if (open.size() > 1) {
                            computeOpen();
                            isMove = true;
                        }
                    }
                }

            }
            if (!isMove ) break;
            cnt++;
        }
        System.out.println(cnt);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
    }
    static void computeOpen() {
        int total = 0;
        for (int i = 0; i < open.size(); i++) {
//            System.out.println(open.get(i).x + " " + open.get(i).y);
            total += board[open.get(i).x][open.get(i).y];
        }
        int avg = total / open.size();
        for (int i = 0; i < open.size(); i++) {
            board[open.get(i).x][open.get(i).y] = avg;
        }
//        System.out.println("total: " + total);
//        System.out.println("avg: " + avg);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
    }

    static boolean bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        boolean isMove = false;

        while(!q.isEmpty()) {
            Point poll = q.poll();
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;
                if(0 <= nx && nx < N && 0 <= ny && ny < N &&
                        !visited[nx][ny]) {
                    int abs = Math.abs(board[nx][ny] - board[poll.x][poll.y]);
                    if(abs <= R && abs >= L) {
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        open.add(new Point(nx, ny));
//                        System.out.println("add:" + nx + " " + ny);
                        isMove = true;
                    }
                }
            }
//            System.out.println("?");
        }
//        System.out.println("end");
//        for(int i = 0; i < open.size(); i++) {
//            System.out.println(open.get(i).x + " " + open.get(i).y);
//        }
//        System.out.println("end");
        return isMove;
    }
}
