package programmers.summerwintercoding;

import javax.management.StringValueExp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 방문길이 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static ArrayList<String> visited;
    static int N = 11;
    static int cnt = 0;

    public static int solution(String dirs) {
        int answer = 0;
        board = new int[N][N];
        visited = new ArrayList<>();
        bfs(5, 5, dirs);

        return visited.size() / 2;
    }

    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
//        String dirs = "LULLLLLLU";
        System.out.println(solution(dirs));
    }

    static void bfs(int x, int y, String dirs) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        int nx = 0, ny = 0;
        boolean flag = true;
        for (int i = 0; i < dirs.length(); i++) {
            Point poll = queue.poll();
            System.out.println(dirs.charAt(i));
            if (dirs.charAt(i) == 'U') {
                nx = poll.x + dx[0];
                ny = poll.y + dy[0];
            } else if (dirs.charAt(i) == 'R') {
                nx = poll.x + dx[1];
                ny = poll.y + dy[1];
            } else if (dirs.charAt(i) == 'D') {
                nx = poll.x + dx[2];
                ny = poll.y + dy[2];
            } else if (dirs.charAt(i) == 'L') {
                nx = poll.x + dx[3];
                ny = poll.y + dy[3];
            }
            flag = extracted(queue, poll, nx, ny, i);
        }

    }

    private static boolean extracted(Queue<Point> queue, Point poll, int nx, int ny, int i) {
        visited.stream().forEach(System.out::println);
        if (0 <= nx && nx < N && 0 <= ny && ny < N) {
            String s = String.valueOf(poll.x) + String.valueOf(poll.y) + String.valueOf(nx) + String.valueOf(ny);
            String reverse_s = String.valueOf(nx) + String.valueOf(ny) + String.valueOf(poll.x) + String.valueOf(poll.y);
            if (visited.contains(s) || visited.contains(reverse_s)) {
                queue.offer(new Point(nx, ny));
            } else {
                queue.offer(new Point(nx, ny));
                System.out.println("i = " + i);
                cnt++;
                visited.add(s);
                visited.add(reverse_s);
            }
            return true;
        }
        queue.offer(new Point(poll.x, poll.y));
        return false;
    }
}
