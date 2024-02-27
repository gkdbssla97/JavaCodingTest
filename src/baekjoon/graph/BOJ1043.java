package baekjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1043 {
    static boolean[] know, visited;
    static ArrayList<ArrayList<Integer>> partyPeople = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> personParty = new ArrayList<>();
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        visited = new boolean[m];
        know = new boolean[n + 1];
        s = br.readLine().split(" ");
        if(s.length == 1) { // 진실된 자 0명
            System.out.println(m);
            System.exit(0);
        } else { // 거짓말쟁이 있다.
            int pCnt = Integer.parseInt(s[0]);

            for(int i = 1; i <= pCnt; i++) {
                know[Integer.parseInt(s[i])] = true;
            }
            for(int i = 0; i <= n; i++) {
                personParty.add(new ArrayList<>());
            }
            for(int i = 0; i < m; i++) {
                partyPeople.add(new ArrayList<>());
                s = br.readLine().split(" ");
                for(int j = 1; j < s.length; j++) {
                    int person = Integer.parseInt(s[j]);
                    partyPeople.get(i).add(person);
                    personParty.get(person).add(i);
                }
            }

            int cnt = 0;
//            System.out.println(Arrays.toString(visited));
            for(int i = 1; i <= n; i++) {
                if(know[i]) dfs(i);
            }
            for(int i = 0; i < m; i++) {
                if(!visited[i]) cnt++;
            }
            System.out.println(cnt);
        }
    }
    static void dfs(int person) {
        for(int party : personParty.get(person)) {
            if(!visited[party]) {
                visited[party] = true;
                for(int p : partyPeople.get(party)) {
                    if(!know[p]) {
                        know[p] = true;
                        dfs(p);
                    }
                }
            }
        }
    }
}
