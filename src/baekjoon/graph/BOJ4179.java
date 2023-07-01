package baekjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ4179 {
    static int R, C;
    static String[][] board;
    static boolean[][] visited_p;
    static boolean[][] visited_f;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Node person;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);

        board = new String[R][C];
        visited_p = new boolean[R][C];
        visited_f = new boolean[R][C];

        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            String[] ss = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                board[i][j] = ss[j];
                if(ss[j].equals("J")) {
                    board[i][j] = ".";
                    person = new Node(i, j, 0, 0);
                } else if(ss[j].equals("F")) {
                    q.offer(new Node(i, j, 0, 1));
                    visited_f[i][j] = true;
                }
            }
        }
        int bfs = bfs(q);
        if(bfs == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(bfs);
        }
    }
    static int bfs(Queue<Node> q) {
        q.add(person);
        visited_p[person.x][person.y] = true;
        while(!q.isEmpty()) {
            Node poll = q.poll();
            if (poll.type == 0) {
                //북
                if(0 == poll.x && board[poll.x][poll.y].equals(".")) {
                    return poll.cost + 1;
                }
                //동
                else if(C - 1 == poll.y && board[poll.x][poll.y].equals(".")) {
                    return poll.cost + 1;
                }
                //남
                else if(R - 1 == poll.x && board[poll.x][poll.y].equals(".")) {
                    return poll.cost + 1;
                }
                //서
                else if(0 == poll.y && board[poll.x][poll.y].equals(".")) {
                    return poll.cost + 1;
                }

                visited_p[poll.x][poll.y] = true;
            } else if (poll.type == 1) {
                visited_f[poll.x][poll.y] = true;
            }

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;

                if(0 <= nx && nx < R && 0 <= ny && ny < C
                        && !board[nx][ny].equals("#")) {
                    if(poll.type == 0 && !visited_p[nx][ny] && !visited_f[nx][ny]) {
                        visited_p[nx][ny] = true;
                        q.offer(new Node(nx, ny, poll.cost + 1, 0));
                    } else if(poll.type == 1 && !visited_f[nx][ny]) {
                        visited_f[nx][ny] = true;
                        q.offer(new Node(nx, ny, poll.cost + 1, 1));
                    }
                }
            }
        }
        return -1;
    }
    static class Node {
        int x, y, cost, type;
        // type == 0 지훈
        // type == 1 불
        Node (int x, int y, int cost, int type) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.type = type;
        }
    }
}
