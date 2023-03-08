package programmers.kakao.카카오채용연계형인턴십2021;

import java.util.Stack;

public class 표편집_answer {
    static class Node {
        Node prev = null;
        Node next = null;
        boolean isDelete;

        public Node() {
            this.isDelete = false;
        }
    }

    public static String solution(int n, int k, String[] cmd) {
        Node[] nodeArr = new Node[1000001];

        nodeArr[0] = new Node();
        for (int i = 1; i < n; i++) {
            nodeArr[i] = new Node();
            nodeArr[i].prev = nodeArr[i - 1];
            nodeArr[i-1].next = nodeArr[i];
        }

        Stack<Node> delete = new Stack<>();
        Node now = nodeArr[k];

        for (String query : cmd) {
            char c = query.charAt(0);

            if (c == 'U') {
                int cnt = Integer.parseInt(query.substring(2));
                for (int i = 0; i < cnt; i++) {
                    now = now.prev;
                }
            } else if (c == 'D') {
                int cnt = Integer.parseInt(query.substring(2));
                for (int i = 0; i < cnt; i++) {
                    now = now.next;
                }
            } else if (c == 'C') {
                now.isDelete = true;
                delete.push(now);

                Node prev = now.prev;
                Node next = now.next;

                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                    now = next;
                } else {
                    now = prev;
                }
            } else {
                Node deletedNode = delete.pop();
                Node prev = deletedNode.prev;
                Node next = deletedNode.next;
                deletedNode.isDelete = false;

                if (prev != null) {
                    prev.next = deletedNode;
                }
                if (next != null) {
                    next.prev = deletedNode;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nodeArr[i].isDelete) {
                sb.append("X");
            } else sb.append("O");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        System.out.println(solution(n, k, cmd));
    }
}
