package programmers.summerwintercoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 스킬트리 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String route : skill_trees) {
            Queue<Character> queue = new LinkedList<>();
            Queue<Character> tmp = new LinkedList<>();
            for (int i = 0; i < skill.length(); i++) {
                queue.offer(skill.charAt(i));
            }
            for (int i = 0; i < route.length(); i++) {
                if (skill.contains(String.valueOf(route.charAt(i)))) {
                    tmp.offer(route.charAt(i));
                }
            }
//            System.out.println("tmp :" + tmp);
            while(true) {
                if(tmp.isEmpty()) {
                    answer++;
                    System.out.println(route);
                    break;
                }
                if (tmp.peek() == queue.peek()) {
//                    System.out.println("route :" + route);
//                    System.out.println(tmp.peek() + " " + queue.peek());
                    tmp.poll();
                    queue.poll();
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String [] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        solution(skill, skill_trees);
    }
}
