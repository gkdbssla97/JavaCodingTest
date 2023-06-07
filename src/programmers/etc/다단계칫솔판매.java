package programmers.etc;

import java.util.*;

public class 다단계칫솔판매 {
    static HashMap<String, String> list = new LinkedHashMap<>();
    static HashMap<String, Integer> money = new LinkedHashMap<>();
    public static List<Integer> solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for(int i = 0; i < enroll.length; i++) {
            list.put(enroll[i], referral[i]);
            money.put(enroll[i], 0);
        }
        for(int i = 0; i < seller.length; i++) {

            int getMoney = amount[i] * 100;
            int get_Money = (int)(getMoney * 0.9);
            int give_Money = (int)(getMoney * 0.1);
            money.put(seller[i], money.get(seller[i]) + get_Money);

            String person = seller[i];
            while(true) {
                int b = (int)(give_Money * 0.1);
                int a = give_Money - b;
                if(a < 1) {
                    break;
                }
                if(!list.get(person).equals("-")) {
                    person = list.get(person);
                    System.out.println("person: " + person + " " + a);
                    money.put(person, money.get(person) + a);
                } else {
                    break;
                }
                give_Money = b;
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> map : money.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
            answer.add(map.getValue());
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        List<Integer> solution = solution(enroll, referral, seller, amount);

        System.out.println(solution);
    }
}
