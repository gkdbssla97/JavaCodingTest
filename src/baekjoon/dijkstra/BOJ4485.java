package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ4485 {
    //dijkstra + BFS
    static int[][] board;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt;

    static class Node implements Comparator<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            if (T == 0) {
                break;
            }

            board = new int[T][T];
            graph = new int[T][T];
            visited = new boolean[T][T];

            for (int i = 0; i < T; i++) {
                int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < T; j++) {
                    board[i][j] = nums[j];
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
            BFS(T);
            cnt++;
        }
    }
    static void BFS(int N) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.offer(new Node(0, 0, board[0][0]));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            visited[poll.x][poll.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;

                if (0 <= nx && nx < N && 0 <= ny && ny < N
                        && !visited[nx][ny] && graph[nx][ny] > board[nx][ny] + poll.cost) {
                    graph[nx][ny] = board[nx][ny] + poll.cost;
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, graph[nx][ny]));
                }
            }
        }
        System.out.println("Problem " + cnt + ": " + graph[N-1][N-1]);
    }
}
