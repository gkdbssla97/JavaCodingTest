package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ20055 {
    static int N, K;
    static int[][] board;
    static boolean[] robot;
    static int time = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        int tmp = N;
        K = Integer.parseInt(s[1]);

        String[] ss = br.readLine().split(" ");
        board = new int[2][N];
        robot = new boolean[N];

        for (int i = 0; i < ss.length / 2; i++) {
            board[0][i] = Integer.parseInt(ss[i]);
        }
        for (int i = ss.length / 2; i < ss.length; i++) {
            board[1][tmp - 1] = Integer.parseInt(ss[i]);
            tmp--;
        }

        while(true) {
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
            spinning();
            time++;
//            print_convey();
//            print_robo();

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            //로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            int idx = N - 2;
            while(idx >= 0) {
                if(robot[N - 1]) {
                    robot[N - 1] = false;
                }
                if (robot[idx] && board[0][idx + 1] >= 1 && !robot[idx + 1]) {
                    board[0][idx + 1] -= 1;
                    robot[idx + 1] = true;
                    robot[idx] = false;
                }
                idx--;
            }

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (board[0][0] >= 1) {
                board[0][0] -= 1;
                robot[0] = true;
            }

            if (check_strength() >= K) {
                break;
            }

            // 4.
//            print_convey();
//            print_robo();
        }
        System.out.println(time - 1);
    }

    private static void print_convey() {
        System.out.println("-----");
        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("-----");
    }

    private static void print_robo() {
        System.out.println("-----");
        System.out.println(Arrays.toString(robot));
        System.out.println("-----");
    }

    static void spinning() {

        // 컨베이어 벨트 자체
        int first = board[0][N - 1];
        int last = board[1][0];

        // 상단
        for (int i = N - 1; i >= 1; i--) {
            board[0][i] = board[0][i - 1];
        }

        // 하단
        for (int i = 1; i < N; i++) {
            board[1][i - 1] = board[1][i];
        }

        board[0][0] = last;
        board[1][N - 1] = first;

        // 로봇 자체
        // 상단
        for (int i = N - 1; i >= 1; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
    }

    static int check_strength() {
        int cnt = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
