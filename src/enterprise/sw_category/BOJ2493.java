package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n + 1];
        String[] s = br.readLine().split(" ");
        for(int i = 1; i <= n; i++) {
            board[i] = Integer.parseInt(s[i - 1]);
        }
        StringBuilder sb = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        int max = 0;
        Node res = null;
        for(int i = 1; i <= n; i++) {
            if(stack.isEmpty()) {
                sb.append(0 + " ");
            } else {
                if(stack.peek().num >= board[i]) {
                    sb.append(stack.peek().idx + " ");
                } else {
                    while (true) {
                        if(stack.isEmpty()) {
                            sb.append(0 + " ");
                            break;
                        }
                        if(stack.peek().num >= board[i]) {
                            sb.append(stack.peek().idx + " ");
                            break;
                        }
                        stack.pop();
                    }
                }
            }
            stack.push(new Node(board[i], i));
        }
        System.out.println(sb.toString());
    }
    static class Node {
        int num, idx;

        Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
