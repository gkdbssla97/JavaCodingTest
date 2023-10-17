package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] _before = br.readLine().split("");
        String[] _after = br.readLine().split("");
        int[] before = changeToIntArray(_before);
        int[] after = changeToIntArray(_after);
        if(isSame(before, after)) System.out.println(0);
        else {
//            System.out.println(Arrays.toString(copy));
            int[] copy = Arrays.copyOf(before, before.length);
            copy[0] = 1 - copy[0];
            copy[1] = 1 - copy[1];
//            System.out.println(Arrays.toString(copy));
            int a = solve(before, after); // 첫번째 바꿈
            int b = solve(copy, after); // 첫번째 바꿈
            if(a == (int)1e9 && b == (int)1e9) System.out.println(-1);
            System.out.println(Math.min(a, b + 1));

        }
    }

    static int solve(int[] b, int[] a) {
        int cnt = 0;
        for(int i = 1; i < b.length; i++) {
            if(b[i - 1] != a[i - 1]) {
                b[i - 1] = 1 - b[i - 1];
                b[i] = 1 - b[i];
                if(i != b.length - 1) {
                    b[i + 1] = 1 - b[i + 1];
                }
                cnt++;
            }
        }
        if(isSame(a, b)) return cnt;
        return (int)1e9;
    }

    static int[] changeToIntArray(String[] s) {
        int[] tmp = new int[s.length];
        for(int i = 0; i < s.length; i++) {
            tmp[i] = Integer.parseInt(s[i]);
        }
        return tmp;
    }

    static boolean isSame(int[] a ,int[] b) {
        boolean flag = true;
        for(int i = 0; i < a.length; i++) {
            if(a[i] == b[i]) continue;
            if(a[i] != b[i]) return false;
        }
        return flag;
    }
}
