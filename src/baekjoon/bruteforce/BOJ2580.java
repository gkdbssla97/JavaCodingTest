package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ2580 {
    static int[][] board = new int[9][9];
    static ArrayList<Info> infos = new ArrayList<Info>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(s[j]);
                if (board[i][j] == 0)
                    infos.add(new Info(i, j, false));
            }

        }

        int zeroCnt = infos.size();
        dfs(0, zeroCnt);
//        print();
    }

    static void dfs(int idx, int zeroCnt) {
        if (zeroCnt == 0) {
            print();
            System.exit(0);
            return;
        }
        Info info = infos.get(idx);
        int x = info.x;
        int y = info.y;
        if (!info.checked) {
            for (int i = 1; i <= 9; i++) {
                if (check(i, x, y)) {
                    info.checked = true;
                    dfs(idx + 1, zeroCnt - 1);
                    board[x][y] = 0;
                    info.checked = false;
                } else {
                    board[x][y] = 0;
                }
            }
        }

    }

    static boolean check(int val, int x, int y) {
        board[x][y] = val;
        boolean[] visited = new boolean[10];
        // 가로
        for (int i = 0; i < 9; i++) {
            int v = board[x][i];
            if (v == 0) continue;
            if (!visited[v]) {
                visited[v] = true;
            } else return false;
        }
        // 세로
        visited = new boolean[10];
        for (int i = 0; i < 9; i++) {
            int v = board[i][y];
            if (v == 0) continue;
            if (!visited[v]) {
                visited[v] = true;
            } else return false;
        }
        // 영역 전개
        // 1구간
        visited = new boolean[10];
        if (x < 3 && y < 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int v = board[i][j];
                    if (v == 0) continue;
                    if (!visited[v]) {
                        visited[v] = true;
                    } else return false;
                }
            }
        }
        // 2구간
        else if (x < 3 && y < 6) {
            for (int i = 0; i < 3; i++) {
                for (int j = 3; j < 6; j++) {
                    int v = board[i][j];
                    if (v == 0) continue;
                    if (!visited[v]) {
                        visited[v] = true;
                    } else return false;
                }
            }
        }
        // 3구간
        else if (x < 3 && y < 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 6; j < 9; j++) {
                    int v = board[i][j];
                    if (v == 0) continue;
                    if (!visited[v]) {
                        visited[v] = true;
                    } else return false;
                }
            }
        }
        // 4구간
        else if (3 <= x && x < 6 && y < 3) {
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    int v = board[i][j];
                    if (v == 0) continue;
                    if (!visited[v]) {
                        visited[v] = true;
                    } else return false;
                }
            }
        }
        // 5구간
        else if (3 <= x && x < 6 && y < 6) {
            for (int i = 3; i < 6; i++) {
                for (int j = 3; j < 6; j++) {
                    int v = board[i][j];
                    if (v == 0) continue;
                    if (!visited[v]) {
                        visited[v] = true;
                    } else return false;
                }
            }
        }
        // 6구간
        else if (3 <= x && x < 6 && y < 9) {
            for (int i = 3; i < 6; i++) {
                for (int j = 6; j < 9; j++) {
                    int v = board[i][j];
                    if (v == 0) continue;
                    if (!visited[v]) {
                        visited[v] = true;
                    } else return false;
                }
            }
        }
        // 7구간
        else if (6 <= x && x < 9 && y < 3) {
            for (int i = 6; i < 9; i++) {
                for (int j = 0; j < 3; j++) {
                    int v = board[i][j];
                    if (v == 0) continue;
                    if (!visited[v]) {
                        visited[v] = true;
                    } else return false;
                }
            }
        }
        // 8구간
        else if (6 <= x && x < 9 && y < 6) {
            for (int i = 6; i < 9; i++) {
                for (int j = 3; j < 6; j++) {
                    int v = board[i][j];
                    if (v == 0) continue;
                    if (!visited[v]) {
                        visited[v] = true;
                    } else return false;
                }
            }
        }
        // 9구간
        else if (6 <= x && x < 9 && y < 9) {
            for (int i = 6; i < 9; i++) {
                for (int j = 6; j < 9; j++) {
                    int v = board[i][j];
                    if (v == 0) continue;
                    if (!visited[v]) {
                        visited[v] = true;
                    } else return false;
                }
            }
        }
        return true;
    }

    static class Info {
        int x, y;
        boolean checked;

        Info(int x, int y, boolean checked) {
            this.x = x;
            this.y = y;
            this.checked = checked;
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
