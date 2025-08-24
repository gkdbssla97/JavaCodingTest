import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] text = br.readLine().toCharArray();
        char[] explosion = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : text) {
            stack.push(c);
            if (stack.size() >= explosion.length) {
                boolean flag = true;
                for (int i = 0; i < explosion.length; i++) {
                    if (stack.get(stack.size() - explosion.length + i) != explosion[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int i = 0; i < explosion.length; i++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
    }
}
