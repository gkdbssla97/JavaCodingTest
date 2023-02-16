package baekjoon.etcProb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2636 {

    static int M, N;
    static int time = 0;
    static List<Integer> remained_cheese;
    static int [][]board;
    static boolean [][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        board = new int[M][N];
        remained_cheese = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < s.length; j++) {
                board[i][j] = s[j];
            }
        }
        int init_cheese = counting_cheese(board);
        bfs();
//        for (int i = 0; i < M; i++) {
//            System.out.print(Arrays.toString(board[i]));
//            System.out.println();
//        }
        System.out.println(time);
        int index = remained_cheese.indexOf(0);
        if(index == 0) System.out.println(init_cheese);
        else System.out.println(remained_cheese.get(index - 1));
    }
    static void bfs() {
        while (true) {
            if (!checked_cheese(board)) break;
            visited = new boolean[M][N];
            visited[0][0] = true;
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0, 0));
            while (!queue.isEmpty()) {
                Point poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + poll.x;
                    int ny = dy[i] + poll.y;
                    if (0 <= nx && nx < M && 0 <= ny && ny < N
                            && !visited[nx][ny]) {
                        if (board[nx][ny] == 1) {
                            visited[nx][ny] = true;
                            board[nx][ny] = 0;
                        } else {
                            visited[nx][ny] = true;
                            queue.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            //System.out.println("??");
            remained_cheese.add(counting_cheese(board));
            time++;
        }
    }

    static boolean checked_cheese(int[][] board) {
        for (int i = 0; i < M; i++) {
            if (Arrays.stream(board[i]).anyMatch(x -> x == 1)) {
                return true;
            }
        } return false;
    }

    static int counting_cheese(int[][] board) {
        int count = 0;
        for (int i = 0; i < M; i++) {
            count += Arrays.stream(board[i]).filter(x -> x == 1).count();
        }
        return count;
    }
}
