//package syntax;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Character> stack;
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            stack = new Stack<>();
            boolean flag = true;
            for(char c : s.toCharArray()) {
                if(c == ')') {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    stack.push(c);
                }
            }
            if(!stack.isEmpty()) flag = false;
            System.out.println(flag ? "YES" : "NO");
        }
    }
}

/**
 * 5
 * 1 3 2 -1
 * 2 4 4 -1
 * 3 1 2 4 3 -1
 * 4 2 4 3 3 5 6 -1
 * 5 4 6 -1
 */
