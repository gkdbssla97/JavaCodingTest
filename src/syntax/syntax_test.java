package syntax;

import java.util.Arrays;
import java.util.List;

public class syntax_test {
    public static void main(String[] args) {

        int r = 5;
        int c = 5;
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };
        int[][] prefix = new int[r + 1][c + 1];
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                prefix[i][j] = prefix[i -1][j] + prefix[i][j-1] - prefix[i-1][j-1] + arr[i-1][j-1];
            }
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println(Arrays.toString(prefix[i]));
        }
    }
}
