package silver_random_defense;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1058 {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for(int i = 1; i <= n; i++){
            String[] s = br.readLine().split("");
            for(int j = 0; j < s.length; j++) {
                if(s[j].equals("Y")) {
                    arr.get(i).add(j + 1);
                }
            }
        }

//        for(int i = 1; i <= n; i++) {
//            System.out.println(arr.get(i));
//        }
        int max = -1;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, bfs(i, n));
        }
        System.out.println(max);
    }

    static int bfs(int start, int n) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(start, 0));
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        while(!q.isEmpty()) {
            Node p = q.poll();
            visited[p.num] = true;

            for(int i = 0; i < arr.get(p.num).size(); i++) {
                Integer v = arr.get(p.num).get(i);
                if(!visited[v] && p.cnt < 2) {
                    visited[v] = true;
                    q.offer(new Node(v, p.cnt + 1));
                }
            }
        }
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(i == start) continue;
            if(visited[i]) cnt++;
        }

        return cnt;
    }

    static class Node {
        int num, cnt;

        Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
