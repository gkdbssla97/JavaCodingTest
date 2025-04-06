//package syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] prefix = new int[array.length + 1];
        for(int i = 0; i < array.length; i++) {
            prefix[i + 1] = prefix[i] + array[i];
        }
//        Arrays.stream(prefix).forEach(x -> System.out.print(x + " "));
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(left <= right && right < prefix.length) {
//            System.out.println("L : R " + left + " " + right);
//            System.out.println("min : " + min);
            sum = prefix[right];
            if(sum >= b) {
                while(left <= right) {
                    if(sum - prefix[left] >= b) {
                        left++;
                    } else {
                        min = Math.min(min, right - left + 1);
                        break;
                    }
//                    System.out.println("L : R " + left + " " + right);
                }
//                System.out.println("최소: " + min);
            }
            right++;
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
