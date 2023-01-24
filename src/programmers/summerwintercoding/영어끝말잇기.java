package programmers.summerwintercoding;

import java.util.ArrayList;
import java.util.List;

public class 영어끝말잇기 {
    public static List<Integer> solution(int n, String[] words) {
        List<Integer> answer = new ArrayList<>();
        List<String> alreadyWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (i != 0 && (alreadyWords.contains(words[i])
                    || alreadyWords.get(alreadyWords.size() - 1).charAt(alreadyWords.get(alreadyWords.size() - 1).length() - 1) != words[i].charAt(0))) {
                if ((i + 1) % n == 0)
                    answer.add(n);
                else answer.add((i + 1) % n);
//                System.out.println(words[i] + " " + (i + 1) / n + " " + (i + 1));

                if ((i + 1) / n == 0)
                    answer.add(1);
                else answer.add((int)Math.ceil((double)(i + 1) / n));
//                System.out.println((int)Math.ceil((double)(i + 1) / n));
                return answer;
            } else {
                alreadyWords.add(words[i]);
            }
        }
        if (answer.size() == 0) {
            answer.add(0);
            answer.add(0);
        }
        return answer;
    }

    public static void main(String[] args) {
//        int n = 3;
//        String[] words = {"tank", "kick", "know",
//                "wheel", "land", "dream",
//                "mother", "robot", "tank"};
//            int n = 5;
//        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};

//        int n = 2;
//        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int n = 3;
        String[] words = {"hello", "oing", "hat"};
        List<Integer> solution = solution(n, words);
        if (solution.size() == 0) {
            System.out.println("[0, 0]");
        } else System.out.println(solution);
    }
}
