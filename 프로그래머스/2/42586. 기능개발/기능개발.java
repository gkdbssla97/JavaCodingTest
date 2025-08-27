import java.util.*;

class Solution {
    static class Node {
        int val, idx;
        
        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        boolean[] visited = new boolean[speeds.length];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        int index = 0;
        for(int p : progresses) {
            q.offer(new Node(p, index++));
        }
        int day = 0;
        while(!q.isEmpty()) {
            Node p = q.peek();
            int t = 100 - p.val;
            if((double)t / (double)speeds[p.idx] == 0) {
                day = 1;
            } else {
                if(t % speeds[p.idx] == 0) {
                    day = (int)((double)t / (double)speeds[p.idx]);
                } else {
                    day = (int)((double)t / (double)speeds[p.idx]) + 1;
                }
            }
            for(Node n : q) {
                n.val += day * speeds[n.idx];
            }
            // System.out.println(Arrays.toString(progresses));
            int cnt = 0;
            while(!q.isEmpty()){
                if(q.peek().val >= 100) {
                        q.poll();
                        cnt++;
                    
                } else break;
            }
            if(cnt > 0) ans.add(cnt);
        }
        return ans.stream().mapToInt(e -> e).toArray();
    }
}