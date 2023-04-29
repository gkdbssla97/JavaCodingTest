package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

class BOJ1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        int M = Integer.parseInt(br.readLine());
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(str));
        ListIterator<String> iter = linkedList.listIterator();

        while (iter.hasNext()) {
            iter.next();
            System.out.println(1);
        }
        System.out.println(2);
        for (int i = 0; i < M; i++) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("P")) {
                iter.add(cmd[1]);
            } else if (cmd[0].equals("L")) {
                if (iter.hasPrevious())
                    iter.previous();
            }else if (cmd[0].equals("D")) {
                if (iter.hasNext())
                    iter.next();
            }else if (cmd[0].equals("B")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
        }
        System.out.println(String.join("",linkedList));
    }
}
