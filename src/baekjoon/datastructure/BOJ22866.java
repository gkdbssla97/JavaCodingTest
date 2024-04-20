package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ22866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Node> stack = new Stack<>();
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        int[] cnt = new int[n + 1];
        // 왼쪽
        for(int i = 0; i < n; i++) {
            int v = s[i];
            if(stack.isEmpty()) {
                stack.push(new Node(i + 1, v));
            } else {
                while(!stack.isEmpty() && stack.peek().height <= s[i]) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    left[i + 1] = stack.peek().idx;
                } else {
                    left[i + 1] = 0;
                }
                cnt[i + 1] += stack.size();
                stack.push(new Node(i + 1, v));
            }
        }
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(cnt));

        stack = new Stack<>();
        // 오른쪽
        for(int i = n - 1; i >= 0; i--) {
            int v = s[i];
            if(stack.isEmpty()) {
                stack.push(new Node(i + 1, v));
            } else {
                while(!stack.isEmpty() && stack.peek().height <= s[i]) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    right[i + 1] = stack.peek().idx;
                } else {
                    right[i + 1] = 0;
                }
                cnt[i + 1] += stack.size();
                stack.push(new Node(i + 1, v));
            }
        }

//        System.out.println(Arrays.toString(right));
//        System.out.println(Arrays.toString(cnt));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(cnt[i + 1] == 0) {
                sb.append("0\n");
            } else {
                int v = -1;
                if(Math.abs((i + 1) - left[i + 1]) > Math.abs((i + 1) - right[i + 1])) {
                    v = right[i + 1];
                } else {
                    v = left[i + 1];
                }
                if(v == 0) {
                    v = Math.max(left[i + 1], right[i + 1]);
                }
                sb.append(cnt[i + 1]).append(" ").append(v).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static class Node {
        int idx, height;

        public Node(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
