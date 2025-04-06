import java.util.*;
import java.util.stream.*;

class Solution {
    static ArrayList<ArrayList<Integer>> arr;
    static HashMap<List<Integer>, Integer> map;
    static int[][] answer;
    static int res = 0;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][];
        map = new LinkedHashMap<>();
        
        arr = new ArrayList<>();
        int size = 100_000;
        for(int i = 0; i <= size; i++) {
            arr.add(new ArrayList<>());
        }
        // 트리를 먼저 만들어야 할거 같은데..
        // 세로가 y, 가로가 x

        for(int i = 0; i < nodeinfo.length; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            
            map.put(Arrays.asList(x, y), i + 1);
        }
        Arrays.sort(nodeinfo, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            } return b[1] - a[1];
        });
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++) {
            // System.out.println(map.get(Arrays.asList(nodeinfo[i][0], nodeinfo[i][1])));
            System.out.println(nodeinfo[i][0] + " " + nodeinfo[i][1]);
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], map.get(Arrays.asList(nodeinfo[i][0], nodeinfo[i][1]))));
        }
        // 트리 구성
        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
        }
        int _size = nodes.size();
        answer[0] = new int[_size];
        preorder(root);
        System.out.println("---");
        answer[1] = new int[_size];
        res = 0;
        postorder(root);
        return answer;
    
    }
    static void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }

    static void preorder(Node node) {
        if (node != null) {
            System.out.print(node.getIdx());
            answer[0][res++] = node.getIdx();
            preorder(node.left);
            preorder(node.right);
        }
    }
                      
    static void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.getIdx());
            answer[1][res++] = node.getIdx();
        }
    }
                      
    class Node {
        int x, y, idx;
        Node left, right;

        Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
        
        public int getIdx() {
            return this.idx;
        }
    }
}