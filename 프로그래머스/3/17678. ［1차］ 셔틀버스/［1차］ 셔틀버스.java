import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int answer = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable) {
            pq.offer(convert(time));
        }
        List<List<Integer>> arr = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());    
        }
        System.out.println(pq);
        int departureTime = 9 * 60;
        for(int i = 0; i < n; i++) {
            while(!pq.isEmpty()) {
                int time = pq.peek();
                if(time <= departureTime && arr.get(i).size() < m) {
                    arr.get(i).add(pq.poll());
                    answer = time - 1;
                } else {
                    break;
                }
            } departureTime += t;
        }
        
        if(arr.get(n - 1).size() < m) {
            answer = departureTime - t;
        }
        return String.join(":", new String[]{String.format("%02d",answer / 60), String.format("%02d", answer % 60)});
    }
    
    public int convert(String str) {
        String[] s = str.split(":");
        
        return Integer.parseInt(s[1]) + Integer.parseInt(s[0]) * 60;
    }
}