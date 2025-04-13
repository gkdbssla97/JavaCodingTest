//package syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            // 1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
            if (v == 1) {
                int _v = Integer.parseInt(s[1]);
                q.addFirst(_v);
            }
            // 2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
            else if (v == 2) {
                int _v = Integer.parseInt(s[1]);
                q.addLast(_v);
            }
            // 3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
            else if (v == 3) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.pollFirst());
                }
            }
            // 4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
            else if (v == 4) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.pollLast());
                }
            }
            // 5: 덱에 들어있는 정수의 개수를 출력한다.
            else if (v == 5) {
                System.out.println(q.size());
            }
            // 6: 덱이 비어있으면 1, 아니면 0을 출력한다.
            else if (v == 6) {
                System.out.println(q.isEmpty() ? 1 : 0);
            }
            // 7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
            else if (v == 7) {
                System.out.println(q.isEmpty() ? -1 : q.peekFirst());
            }
            // 8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
            else if (v == 8) {
                System.out.println(q.isEmpty() ? -1 : q.peekLast());
            }
        }
    }
}
/**
 * 1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
 * 2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
 * 3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 5: 덱에 들어있는 정수의 개수를 출력한다.
 * 6: 덱이 비어있으면 1, 아니면 0을 출력한다.
 * 7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 * 8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 * <p>
 * 11
 * 6
 * 1 3
 * 1 8
 * 7
 * 8
 * 3
 * 2 5
 * 1 2
 * 5
 * 4
 * 4
 */

/**
 * 11
 * 6
 * 1 3
 * 1 8
 * 7
 * 8
 * 3
 * 2 5
 * 1 2
 * 5
 * 4
 * 4
 */