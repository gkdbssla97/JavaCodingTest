import java.util.*;
import java.util.stream.*;
class Solution {
    static int plusServer;
    static int total = 0;
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Deque<Node> q = new ArrayDeque<>();
        for(int player : players) {
            
            // 게임 이용자 수가 m명 미만인가? -> continue;
            // 게임 이용자 수가 n * m명 이상, (n + 1) * m 미만인가?
            if(player >= m) {
                int server = player / m;
                int size = q.size();
                // 증설할 필요가 있는가?
                if(server > size) {
                    total += server - size;
                    for(int i = 0; i < server - size; i++) {
                        q.offerLast(new Node(k));
                    }    
                }
            }
            // 서버 반납하기
            returnServer(k, q);
        }
        return total;
    }
    
    public void returnServer(int k, Deque<Node> q) {
        
        while(!q.isEmpty()) {
            Node p = q.peek();
            if(p.time == 1) q.pollFirst();
            else break;
        }
        int size = q.size();
        for(int i = 0; i < size; i++) {
            Node p = q.pollFirst();
            q.offerLast(new Node(p.time - 1));
        }
    }
    
    static class Node {
        int time;
        Node(int time) {
            this.time = time;
        }
    }
}