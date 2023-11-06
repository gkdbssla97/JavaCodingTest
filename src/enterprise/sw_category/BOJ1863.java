package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BOJ1863 {
    static int n;
    static ArrayList<Integer[]> arr = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int zero_cnt = 0;
        int building = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            while(!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                building++;
            }
            if(!stack.isEmpty() && stack.peek() == y) continue;
            stack.push(y);
        }
//        System.out.println("size: " + stack.size());
        while(!stack.isEmpty()) {
            if(stack.peek() > 0) {
                building++;
            }
            System.out.println(stack.pop());
        }
        System.out.println(building);
    }

}

