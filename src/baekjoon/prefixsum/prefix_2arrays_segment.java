package baekjoon.prefixsum;

import java.util.Arrays;

public class prefix_2arrays_segment {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int size = matrix.length;
        System.out.println(size);
        int[][] prefix_sum = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                prefix_sum[i][j] = matrix[i - 1][j - 1] + prefix_sum[i - 1][j] +
                        prefix_sum[i][j - 1] - prefix_sum[i - 1][j - 1];
            }
        }
        Arrays.stream(prefix_sum).forEach(array -> System.out.println(Arrays.toString(array)));
    }
}
