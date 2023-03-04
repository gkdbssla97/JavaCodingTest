package programmers.kakao.카카오채용연계형인턴십2021;

import java.util.*;

public class 거리두기확인하기 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static char[][] board;
    static boolean[][] visited;

    public static int[] solution(String[][] places) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (String[] s : places) {
            board = new char[5][5];
            visited = new boolean[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = s[i].charAt(j);
                }
            }
            PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cnt, o1.cnt));
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (board[i][j] == 'P') {
                        q.offer(new Point(i, j, 0));
                    }
                }
            }
            answer.add(bfs(q, board, visited));
        }
        answer.forEach(System.out::println);
        return answer.stream().mapToInt(x -> x).toArray();
    }

    static int bfs(Queue<Point> q, char[][] board, boolean[][] visited) {
        while (!q.isEmpty()) {
            Point poll = q.poll();
            visited[poll.x][poll.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;

                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5
                        && !visited[nx][ny] && board[nx][ny] == 'P') {
                    visited[nx][ny] = true;
                    if(poll.cnt + 1 <= 2)
                        return 0;
                }

                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5
                        && !visited[nx][ny] && board[nx][ny] == 'O') {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, poll.cnt + 1));
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String[][] places = {
//                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
//                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
//                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
//                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"},
                {"POPXP",
                 "XPXPX",
                 "PXPXP",
                 "XPXPX",
                 "PXPXP"}
        };
        solution(places);
    }
}
