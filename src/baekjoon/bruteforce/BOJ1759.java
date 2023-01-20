package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1759 {
    static int L, C;
    static boolean[] visited;
    static String[] s;
    static ArrayList<ArrayList<String>> res;
    static long countMoumWithJaum(List<String> arr) {
        long count = arr.stream().
                filter(x -> x.equals("a") || x.equals("e") || x.equals("i") || x.equals("o") || x.equals("u")).count();
        if (count >= 1) {
            return count;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[C];
        res = new ArrayList<>();
        s = br.readLine().split(" ");

        bfs(0, C, L);
        for (ArrayList<String> s : res) {
            Collections.sort(s);
        }
        res.sort(new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        for (ArrayList<String> s : res) {
            for (String x : s) {
                System.out.print(x);
            }
            System.out.println();
        }

    }

    static void bfs(int start, int n, int r) {
        if (r == 0) {
            ArrayList<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    board.add(s[i]);
                }
            }
            long l = countMoumWithJaum(board);
            if (l != -1 && board.size() - l >= 2) {
                res.add(board);
            }
            return;
        }
        if (start == n)
            return;
        visited[start] = true;
        bfs(start + 1, n, r - 1);
        visited[start] = false;
        bfs(start + 1, n, r);
    }
}
