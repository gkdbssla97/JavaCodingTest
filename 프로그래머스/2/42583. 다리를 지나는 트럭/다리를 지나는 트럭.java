import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 총 걸린 시간
        Queue<Truck> waitingQ = new LinkedList<>();
        Queue<Truck> movingQ = new LinkedList<>();
        for(int t : truck_weights) {
            waitingQ.offer(new Truck(t));
        }
        
        int curWeight = 0;
        while(!waitingQ.isEmpty() || !movingQ.isEmpty()) {
            answer++;
            if(movingQ.isEmpty()) {
                Truck w = waitingQ.poll();
                w.moving();
                movingQ.offer(w);
                curWeight += w.getWeight();
                continue;
            }
            
            for(Truck t : movingQ) {
                t.moving();
            }
            
            if(movingQ.peek().getMoving() > bridge_length) {
                Truck m = movingQ.poll();
                curWeight -= m.getWeight();
            }
            
            if(!waitingQ.isEmpty() && curWeight + waitingQ.peek().getWeight() <= weight) {
                Truck w = waitingQ.poll();
                w.moving();
                movingQ.offer(w);
                curWeight += w.getWeight();
            }
        
        }
        return answer;
    }
    static class Truck {
        int weight;
        int moving;
        
        Truck(int weight) {
            this.weight = weight;
            this.moving = 0;
        }
        
        void moving() {
            this.moving++;
        }
        
        public int getWeight() {
            return this.weight;
        }
        
        public int getMoving() {
            return this.moving;
        }
    }
}