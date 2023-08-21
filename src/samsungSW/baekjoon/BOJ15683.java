package samsungSW.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 21:35~
public class BOJ15683 {
    static int N, M, def;
    static int[][] board;
    static int[] selected;
    static boolean[][] visited;
    static boolean[] _v;
    static int res = Integer.MAX_VALUE;
    static ArrayList<Node> cameras = new ArrayList<>();
    static ArrayList<Node> wall = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] ss = br.readLine().split(" ");
            for (int j = 0; j < ss.length; j++) {
                board[i][j] = Integer.parseInt(ss[j]);
                if (1 <= board[i][j] && board[i][j] <= 5) {
                    cameras.add(new Node(i, j, board[i][j]));

                } else if(board[i][j] == 6) {
                    wall.add(new Node(i, j, 0));
                }
            }
        }
//        System.out.println(cameras.size() + " " + cameras.get(0).num);
        selected = new int[cameras.size()];
        _v = new boolean[5];
        dfs(0, cameras.size());
        System.out.println(res);
    }

    static void dfs(int start, int n) {
        if (start == n) {
            visited = new boolean[N][M];
            for(Node w : wall) {
                visited[w.x][w.y] = true;
            }
//            System.out.println(Arrays.toString(selected));
            for (int i = 0; i < selected.length; i++) {
                Node camera = cameras.get(i);
                vision(camera, selected[i]);
//                System.out.println("-> " + camera.num);
            }
            int cnt1 = check();
            int cnt = (M * N) - cnt1;

            res = Math.min(res, cnt);
//            System.out.println(M * N + " " + cnt1 + " ");
            if(cnt == -1) {
                {
                    for (int k = 0; k < N; k++) {
                        System.out.println(Arrays.toString(visited[k]));
                    }
                }
                System.out.println("----");
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            selected[start] = i + 1;
            dfs(start + 1, n);
        }
    }

    static class Node {
        int x, y, num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    static int check() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j]) cnt++;
            }
        }
        return cnt;
    }
    /**
     * dir
     * 1 -> 북
     * 2 -> 동
     * 3 -> 남
     * 4 -> 서
     */
    static void vision(Node n, int dir) {
        visited[n.x][n.y] = true;

        if (n.num == 1) {
            if (dir == 1) {
                for (int i = n.x - 1; i >= 0; i--) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
            } else if (dir == 2) {
                for (int i = n.y + 1; i < M; i++) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
            } else if (dir == 3) {
                for (int i = n.x + 1; i < N; i++) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
            } else if (dir == 4) {
                for (int i = n.y - 1; i >= 0; i--) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
            }
        } else if (n.num == 2) {
            if (dir == 1 || dir == 3) {
                for (int i = n.x - 1; i >= 0; i--) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
                for (int i = n.x + 1; i < N; i++) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
            } else if (dir == 2 || dir == 4) {
                for (int i = n.y + 1; i < M; i++) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
                for (int i = n.y - 1; i >= 0; i--) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
            }
        } else if (n.num == 3) {
            if (dir == 1) {
                for (int i = n.x - 1; i >= 0; i--) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
                for (int i = n.y + 1; i < M; i++) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
            } else if (dir == 2) {
                for (int i = n.y + 1; i < M; i++) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
                for (int i = n.x + 1; i < N; i++) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
            } else if (dir == 3) {
                for (int i = n.x + 1; i < N; i++) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
                for (int i = n.y - 1; i >= 0; i--) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
            } else if (dir == 4) {
                for (int i = n.y - 1; i >= 0; i--) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
                for (int i = n.x - 1; i >= 0; i--) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
            }
        } else if (n.num == 4) {
            if (dir == 1) {
                for (int i = n.x - 1; i >= 0; i--) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
                for (int i = n.y + 1; i < M; i++) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
                for (int i = n.y - 1; i >= 0; i--) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
            } else if (dir == 2) {
                for (int i = n.x + 1; i < N; i++) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
                for (int i = n.x - 1; i >= 0; i--) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
                for (int i = n.y + 1; i < M; i++) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
            } else if (dir == 3) {
                for (int i = n.x + 1; i < N; i++) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
                for (int i = n.y + 1; i < M; i++) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
                for (int i = n.y - 1; i >= 0; i--) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
            } else if (dir == 4) {
                for (int i = n.x + 1; i < N; i++) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
                for (int i = n.x - 1; i >= 0; i--) {
                    if (board[i][n.y] != 6) {
                        visited[i][n.y] = true;
                    } else break;
                }
                for (int i = n.y - 1; i >= 0; i--) {
                    if (board[n.x][i] != 6) {
                        visited[n.x][i] = true;
                    } else break;
                }
            }
        } else if (n.num == 5) {
            for (int i = n.x - 1; i >= 0; i--) {
                if (board[i][n.y] != 6) {
                    visited[i][n.y] = true;
                } else break;
            }
            for (int i = n.y + 1; i < M; i++) {
                if (board[n.x][i] != 6) {
                    visited[n.x][i] = true;
                } else break;
            }
            for (int i = n.x + 1; i < N; i++) {
                if (board[i][n.y] != 6) {
                    visited[i][n.y] = true;
                } else break;
            }
            for (int i = n.y - 1; i >= 0; i--) {
                if (board[n.x][i] != 6) {
                    visited[n.x][i] = true;
                } else break;
            }
        }
    }
}
/**
 * 1번 -> 4번
 * 2번 -> 2번
 * 3번 -> 4번
 * 4번 -> 4번
 * 5번 -> 1번
 */
