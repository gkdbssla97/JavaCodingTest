package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ14891_1 {
    static String[] tire = new String[4];
    static int K, name, dir;
    static int[] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tire[0] = br.readLine();
        tire[1] = br.readLine();
        tire[2] = br.readLine();
        tire[3] = br.readLine();

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] k = br.readLine().split(" ");
            name = Integer.parseInt(k[0]) - 1;
            dir = Integer.parseInt(k[1]);

//            System.out.println("---기준---");
//            System.out.println(tire[name]);
//            System.out.println("------");
            d = new int[4];
            d[name] = dir;
            // 왼쪽
            for (int x = name - 1; x >= 0; x--) {
                //기준점의 극
                char unit = tire[x + 1].charAt(6);
                // 회전당하는 극
                char _unit = tire[x].charAt(2);
                if (unit != _unit) {
                    d[x] = -d[x + 1];
                } else {
                    break;
                }
            }
            // 오른쪽
            for (int y = name + 1; y < 4; y++) {

                //기준점의 극
                char unit = tire[y - 1].charAt(2);
                // 회전당하는 극
                char _unit = tire[y].charAt(6);
                if (unit != _unit) {
                    d[y] = -d[y - 1];
                } else {
                    break;
                }
            }

            for (int z = 0; z < 4; z++) {
                if (d[z] == 1) {
                    tire[z] = clock_spinning(tire[z]);
                } else if (d[z] == -1) {
                    tire[z] = reverse_clock_spinning(tire[z]);
                }
            }
//            print(tire[0]);
//            print(tire[1]);
//            print(tire[2]);
//            print(tire[3]);
//            System.out.println("----");
        }
//        System.out.println(tire[0].charAt(0));
//        System.out.println(tire[1].charAt(0));
//        System.out.println(tire[2].charAt(0));
//        System.out.println(tire[3].charAt(0));
//        print(tire[0]);
//        print(tire[1]);
//        print(tire[2]);
//        print(tire[3]);
        int total = 0;
        if (tire[0].charAt(0) == '1') {
            total += 1;
        }
        if (tire[1].charAt(0) == '1') {
            total += 2;
        }
        if (tire[2].charAt(0) == '1') {
            total += 4;
        }
        if (tire[3].charAt(0) == '1') {
            total += 8;
        }

        System.out.println(total);
    }

    private static void print(String s) {
        System.out.println(s);
    }

    // 시계방향 회전
    static String clock_spinning(String s) {
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }

    // 반시계방향 회전
    static String reverse_clock_spinning(String s) {
        return s.substring(1) + s.charAt(0);
    }
}
