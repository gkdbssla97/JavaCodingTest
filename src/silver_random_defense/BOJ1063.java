package silver_random_defense;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1063 {
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] king = new int[2];
        int[] doll = new int[2];

        for (int i = 0; i < s.length - 1; i++) {
            int r, c;
            String[] loc = s[i].split("");
            char[] chars = loc[0].toCharArray();
            c = chars[0] - 'A';
            r = 8 - Integer.parseInt(loc[1]);
//            System.out.println(r + " " + c);
            if (i == 0) {
                king[0] = r;
                king[1] = c;
            } else {
                doll[0] = r;
                doll[1] = c;
            }
        }
        int n = Integer.parseInt(s[s.length - 1]);
        for (int i = 0; i < n; i++) {
            String dir = br.readLine();
            int d = findDirection(dir);

            int nx = dx[d] + king[0];
            int ny = dy[d] + king[1];

            if (nx == doll[0] && ny == doll[1]) {

                int dnx = dx[d] + doll[0];
                int dny = dy[d] + doll[1];

                if (isRange(dnx, dny)) {
                    king[0] = nx;
                    king[1] = ny;
                    doll[0] = dnx;
                    doll[1] = dny;
                }
            } else {
                if (isRange(nx, ny)) {
                    king[0] = nx;
                    king[1] = ny;
                }
            }
//            System.out.println(converting(king));
//            System.out.println(converting(doll));
        }
//        int[][] board = new int[][];
//        System.out.println("---");
        System.out.println(converting(king));
        System.out.println(converting(doll));
    }

    static String converting(int[] ints) {
        int x = ints[0];
        int y = ints[1];

        char c = (char) (y + 'A');
        int r = 8 - x;
        String a = String.valueOf(r);

        return c + a;
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < 8 && 0 <= y && y < 8;
    }

    static int findDirection(String dir) {
        switch (dir) {
            case "R":
                return 0;
            case "L":
                return 1;
            case "B":
                return 2;
            case "T":
                return 3;
            case "RT":
                return 4;
            case "LT":
                return 5;
            case "RB":
                return 6;
        }
        return 7;
    }
}
