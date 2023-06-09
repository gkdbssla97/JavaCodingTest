package programmers.highscorekit.heap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] aa = {{0, 1}, {1, 1}, {2, 2}};
        System.out.println(aa.length);
        PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> {
            int a = o1.y;
            int b = o2.y;
            if (a > b) {
                return 1;
            }
            else return 0;
        });
        queue.offer(new Point(0, 11));
        queue.offer(new Point(1, 9));
        queue.offer(new Point(2, 6));
        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            System.out.println(poll.x + " " + poll.y);
        }
    }
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
