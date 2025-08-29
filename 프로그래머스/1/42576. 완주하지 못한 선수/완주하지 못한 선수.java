import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for(String c : completion) {
            if(map.containsKey(c)) {
                int v = map.get(c);
                map.put(c, v - 1);
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 0) {
                continue;
            } return entry.getKey();
        }
        return answer;
    }
}