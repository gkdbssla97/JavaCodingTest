package programmers.kakao.level3;

import java.util.*;

//231122 19:16~
class 경주로건설 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] visited;
    static int len;

    public int solution(int[][] board) {
        int answer = 0;
        len = board.length;
        visited = new int[len][len][4];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                for (int k = 0; k < 4; k++)
                    visited[i][j][k] = Integer.MAX_VALUE;
        answer = bfs(0, 0, board);
        print();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) res = Math.min(res, visited[len - 1][len - 1][i]);
        return res;
    }

    static int bfs(int x, int y, int[][] board) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, -1, 0, 0));
        for (int i = 0; i < 4; i++)
            visited[0][0][i] = 0;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {

            Node p = q.poll();

            if (isExit(p.x, p.y)) {
                min = Math.min(min, p.cost);
            }

            for (int i = 0; i < 4; i++) {
                // 0 북
                // 1 동
                // 2 남
                // 3 서
                // 짝수면 직선 -> 100
                // 홀수면 코너 -> 500
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (isRange(nx, ny) && board[nx][ny] == 0) {

                    int sum = 0;
                    if (p.dir != -1 && (p.dir + i) % 2 != 0) {
                        sum += 500;
                    }
                    if (visited[nx][ny][i] >= p.cost + 100 + sum) {
                        q.offer(new Node(nx, ny, i, p.cost + 100 + sum, p.cnt + 1));
                        visited[nx][ny][i] = p.cost + 100 + sum;
                    }
                    // System.out.println(p.x + " " + p.y + " " + p.dir + " " + p.cost);
                    // System.out.println(nx + " " + ny + " " + i + " " + (int)(p.cost + 100 + sum));
                }
            }
        }
        return min;
    }

    static boolean isExit(int x, int y) {
        return x == len - 1 && y == len - 1;
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < len && 0 <= y && y < len;
    }

    static class Node {
        int x, y, dir, cost, cnt, hCnt;

        Node(int x, int y, int dir, int cost, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
            this.cnt = cnt;
        }
    }

    static void print() {
        for (int i = 0; i < len; i++) System.out.println(Arrays.toString(visited[i]));
    }
}
