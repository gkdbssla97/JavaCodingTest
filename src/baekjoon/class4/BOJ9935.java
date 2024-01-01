package baekjoon.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            boolean flag = true;
            if(stack.size() >= bomb.length()) {
                for(int j = 0; j < bomb.length(); j++) {
                    Character c = stack.get(stack.size() - bomb.length() + j);
                    if(c != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if(stack.size() == 0) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse().toString());
        }
    }
}
/**
 * mirkovC4nizCC44
 * C4
 */