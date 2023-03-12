package syntax;

import java.util.Arrays;

// 중복조합
public class CombinationWithRepetition {
    static void CWP(int[] arr, int r, int[] tmp, int cur, int start) {
        if (cur == r) {
            System.out.println(Arrays.toString(tmp));
        } else {
            for (int i = start; i < arr.length; i++) {
                tmp[cur] = arr[i];
                CWP(arr, r, tmp, cur + 1, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9};

        // nCr -> n개 중 r개 추출
        int n = arr.length;
        int r = 3;
        int[] res = new int[r];
        CWP(arr, r, res, 0, 0);
    }
}
