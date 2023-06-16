package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//20230618 14:51
public class BOJ17144  {
    static int R, C, T;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        T = Integer.parseInt(s[2]);

        board = new int[R][C];
        visited = new boolean[R][C];
        Point top = new Point(0, 0, 0);
        Point bottom = new Point(0, 0, 0);
        int cnt = 0;
        for(int i = 0; i < R; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < ss.length; j++) {
                board[i][j] = Integer.parseInt(ss[j]);
                if(board[i][j] == -1 && cnt == 0) {
                    top = new Point(i, j, -1);
                    cnt++;
                } else if(board[i][j] == -1 && cnt == 1) {
                    bottom = new Point(i, j, -1);
                }
            }
        }

        int time = 0;
        while(time < T) {
            Queue<Point> q = new LinkedList<>();

            // 미세먼지 확산
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] > 0) {
//                    visited[i][j] = true;
                        q.offer(new Point(i, j, board[i][j]));
                    }
                }
            }
//            System.out.println(q.size());
            bfs(q, board);
            // 청소기 작동
            // 상단(spinning_top)
            spinning_top(top);
            // 하단(spinning_bottom)
            spinning_bottom(bottom);
            time++;
        }

//        print();
        int sum = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(board[i][j] == -1) continue;
                sum += board[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void print() {
        for(int i = 0; i < R; i++) {
            System.out.print(Arrays.toString(board[i]));
            System.out.println();
        }
    }

    static void bfs(Queue<Point> q, int[][] board) {
        while(!q.isEmpty()) {
            Point p = q.poll();
//            visited[p.x][p.y] = true;
            int dir = 0;
            // 가능한 방향 체크
            Queue<Point> adder = new LinkedList<>();
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if(0 <= nx && nx < R && 0 <= ny && ny < C
                && board[nx][ny] >= 0) {
                    dir++;
                    adder.offer(new Point(nx, ny, board[nx][ny]));
                }
            }
            if(dir >= 0) {
                int m = p.cost / 5;
                for (int j = 0; j < dir; j++) {
                    Point pr = adder.poll();
                    board[pr.x][pr.y] += m;
                }
                board[p.x][p.y] -= (m * dir);
            }
        }
    }

    static void spinning_top(Point top) {
        for(int i = top.x - 1; i > 0; i--) {
            board[i][0] = board[i - 1][0];
        }
//        print();
        for(int i = 0; i < C - 1; i++) {
            board[0][i] = board[0][i + 1];
        }
//        print();
        for(int i = 0; i < top.x; i++) {
            board[i][C - 1] = board[i + 1][C - 1];
        }
        for(int i = C - 1; i > 1; i--) {
            board[top.x][i] = board[top.x][i - 1];
        }
        board[top.x][1] = 0;
    }

    static void spinning_bottom(Point bottom) {
        for(int i = bottom.x + 1; i < R - 1; i++) {
            board[i][0] = board[i + 1][0];
        }
        for(int i = 0; i < C - 1; i++) {
            board[R - 1][i] = board[R - 1][i + 1];
        }
        for(int i = R - 1; i >= bottom.x + 1; i--) {
            board[i][C - 1] = board[i - 1][C - 1];
        }
        for(int i = C - 1; i >= 1; i--) {
            board[bottom.x][i] = board[bottom.x][i - 1];
        }
        board[bottom.x][1] = 0;
    }

    static class Point {
        int x, y, cost;
        Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
