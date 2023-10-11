package samsungSW.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 231011 19:20 ~
public class BOJ20058 {
    static int n, q, len, res;
    static int[][] board, tmp;
    static boolean[][] visited;
    static int[] L;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Node> arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        q = Integer.parseInt(s[1]);
        len = (int) Math.pow(2, n);
        board = new int[len][len];
        L = new int[q];
        for (int i = 0; i < len; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            L[i] = Integer.parseInt(s[i]);
        }
        // 부분배열 나누기 2^L
        for (int p = 0; p < L.length; p++) {
            tmp = new int[len][len];
            int pLen = (int) Math.pow(2, L[p]);
            for (int i = 0; i < len; i += pLen) {
                for (int j = 0; j < len; j += pLen) {
                    int sx = i;
                    int sy = j;
                    // 배열돌리기
                    rotate(sx, sy, pLen);
                }
            }
            arr = new ArrayList<>();
            // 사방탐색 얼음 확인
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    attackIce(i, j);
                }
            }
            // 대상자 얼음 -1 만큼 감소
            for (Node ice : arr) {
                if (tmp[ice.x][ice.y] > 0) {
                    tmp[ice.x][ice.y] -= 1;
                }
            }
            board = new int[len][len];
            copy();
        }
        // 1. 남아있는 얼음의 합
        int sum = checkIce();

        // 2. 가장 큰 덩어리가 차지하는 칸의 갯수
        visited = new boolean[len][len];
        res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (tmp[i][j] > 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    int v = bfs(i, j);
                    res = Math.max(res, v);
                }
            }
        }
//            print();
        System.out.println(sum);
        System.out.println(res);
    }
    static void copy() {
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                board[i][j] = tmp[i][j];
            }
        }
    }

    static int bfs(int x, int y) {
        int cnt = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node p = q.poll();

            visited[p.x][p.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (isRange(nx, ny) && !visited[nx][ny] && board[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int checkIce() {
        int sumIce = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] > 0) sumIce += tmp[i][j];
            }
        }
        return sumIce;
    }

    static void attackIce(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isRange(nx, ny) && tmp[nx][ny] > 0) {
                cnt++;
            }
        }
        if (cnt <= 2) {
            arr.add(new Node(x, y));
        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < len && 0 <= y && y < len;
    }

    static void rotate(int sx, int sy, int l) {
        int ex = sx + l - 1;
        int ey = sy + l - 1;
        Queue<Integer> q = new LinkedList<>();
        for (int i = sx; i < sx + l; i++) {
            for (int j = sy; j < sy + l; j++) {
                q.offer(board[i][j]);
            }
        }
        for (int _i = ey; _i >= sy; _i--) {
            for (int _j = sx; _j < sx + l; _j++) {
                tmp[_j][_i] = q.poll();
            }
        }
    }

    static void print() {
        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(tmp[i]));
        }
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
