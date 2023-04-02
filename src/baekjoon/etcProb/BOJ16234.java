package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int L;
    static int R;
    static int cnt = 0;
    static ArrayList<Point> list;

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
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        while(true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(board, i, j);
                        if (list.size() > 1) {
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if(!isMove) break;
            cnt++;
        }
        System.out.println(cnt);
    }

    static void changePopulation(int sum) {
        int avg = sum / list.size();
        for(Point n : list) {
            board[n.x][n.y] = avg;
        }
    }

    static int bfs(int[][] board,int x , int y) {
        Queue<Point> q = new LinkedList<>();
        list = new ArrayList<>();
        q.add(new Point(x, y));
        list.add(new Point(x, y));
        visited[x][y] = true;

        int sum = board[x][y];
        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;
                if (0 <= nx && nx < N && 0 <= ny && ny < N
                        && !visited[nx][ny]) {
                    int abs = Math.abs(board[poll.x][poll.y] - board[nx][ny]);

                    if (abs >= L && abs <= R) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                        list.add(new Point(nx, ny));
                        sum += board[nx][ny];
                    }
                }

            }
        }

//        for(int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println();
        return sum;
    }
}
