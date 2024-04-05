package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9328 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<ArrayList<Node>> gates;
    static HashMap<Character, Character> keyMap;
    static char[][] map;
    static int r, c, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String[] s = br.readLine().split(" ");
            r = Integer.parseInt(s[0]);
            c = Integer.parseInt(s[1]);

            answer = 0;
            map = new char[r][c];

            for (int i = 0; i < r; i++) {
                String str = br.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            gates = new ArrayList<>();
            for(int i = 0; i < 26; i++) {
                gates.add(new ArrayList<>());
            }

            String hasKey = br.readLine();
            keyMap = matchKey(hasKey);
            go();
            sb.append(answer).append("\n");
//            print();
//            System.out.println("----");
        }
        System.out.println(sb.toString());
    }
    static void print() {
        for(Map.Entry<Character, Character> keyMap : keyMap.entrySet()) {
            System.out.println(keyMap.getKey() + " " + keyMap.getValue());
        }
    }
    static HashMap<Character, Character> matchKey(String key) {
        HashMap<Character, Character> map = new LinkedHashMap<>();
        if(key.equals("0")) return map;
        for(int i = 0; i < key.length(); i++) {
            map.put(Character.toUpperCase(key.charAt(i)), key.charAt(i));
        }

        return map;
    }

    static void go() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                    char ch = map[i][j];
                    if(ch == '*') continue;
                    if(Character.isLowerCase(ch)) {
                        keyMap.put(Character.toUpperCase(ch), ch);
                        visited[i][j] = true;
                        q.offer(new Node(i, j));
                    } else if(ch == '$') {
                        map[i][j] = '.';
                        q.offer(new Node(i, j));
                        visited[i][j] = true;
                        answer++;
                    } else if(ch == '.') {
                        visited[i][j] = true;
                        q.offer(new Node(i, j));
                    }

                    if(Character.isUpperCase(ch)) {
                        if(keyMap.containsKey(ch)) {
                            visited[i][j] = true;
                            q.offer(new Node(i, j));
                        } else {
                            gates.get(ch - 'A').add(new Node(i, j));
                        }
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            Node p = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(isRange(nx, ny) && map[nx][ny] != '*' && !visited[nx][ny]) {
                    char ch = map[nx][ny];
                    if(Character.isLowerCase(map[nx][ny])) {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        map[nx][ny] = '.';
                        keyMap.put(Character.toUpperCase(ch), ch);

                        for(Node node : gates.get(ch - 'a')) {
                            map[node.x][node.y] = '.';
                            visited[node.x][node.y] = true;
                            q.offer(new Node(node.x, node.y));
                        }
                    } else if(map[nx][ny] == '$') {
                        q.offer(new Node(nx, ny));
                        map[nx][ny] = '.';
                        visited[nx][ny] = true;
                        answer++;
                    } else if(map[nx][ny] == '.') {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    } else if(Character.isUpperCase(ch)) {
                        if(keyMap.containsKey(ch)) {
                            q.offer(new Node(nx, ny));
                            visited[nx][ny] = true;
                            map[nx][ny] = '.';
                        } else {
                            gates.get(ch - 'A').add(new Node(nx, ny));
                        }
                    }
                }
            }
        }
    }
    static boolean isRange(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
