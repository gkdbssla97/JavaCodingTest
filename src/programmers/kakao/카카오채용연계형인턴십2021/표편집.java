package programmers.kakao.카카오채용연계형인턴십2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class 표편집 {
    public static String solution(int n, int k, String[] cmd) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            answer.add("O");
        }
        Stack<Integer> stack = new Stack<>();
        int dir = k;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i, i);
        }
        int order = 1;
        for (String c : cmd) {
            String[] s = c.split(" ");
            if (s[0].equals("D")) {
                dir += Integer.parseInt(s[1]);
            } else if(s[0].equals("U")) {
                dir -= Integer.parseInt(s[1]);
            } else if (s[0].equals("C")) {
                if (dir == linkedList.size() - 1) {
                    Integer remove = linkedList.remove(dir);
                    stack.push(remove);
                    dir -= 1;
                } else {
                    Integer remove = linkedList.remove(dir);
                    stack.push(remove);
                }
            } else if (s[0].equals("Z")) {
                Integer pop = stack.pop();
                if(pop > linkedList.size() - 1) {
                    linkedList.addLast(pop);
                } else {
                    if(pop < dir)
                        dir +=1;
                    linkedList.add(pop, pop);
                }
            }
            System.out.println(linkedList);
            System.out.println("idx = " + dir);
            if(stack.size() >= 1)
                System.out.println(stack.peek());
            System.out.println("order = " + order);
            order++;
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            answer.set(pop, "X");
        }
        String res = "";
        for (String s : answer) {
            res += s;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        System.out.println(solution(n, k, cmd));
    }
}
