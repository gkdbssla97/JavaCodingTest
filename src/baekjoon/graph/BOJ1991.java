package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Node {
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    public void createNode(String data, String leftData, String rightData) {
        if (root == null) {
            root = new Node(data);
            if(!leftData.equals(".")) {
                root.left = new Node(leftData);
            }
            if(!rightData.equals(".")) {
                root.right = new Node(rightData);
            }
        } else {
            getSearchNode(root, data, leftData, rightData);
        }
    }

    private void getSearchNode(Node root, String data, String leftData, String rightData) {
        if (root == null) {
            return;
        } else if (root.data.equals(data)) {
            if (!leftData.equals(".")) {
                root.left = new Node(leftData);
            }
            if (!rightData.equals(".")) {
                root.right = new Node(rightData);
            }
        } else {
            getSearchNode(root.left, data, leftData, rightData);
            getSearchNode(root.right, data, leftData, rightData);
        }
    }

    public void preorder(Node root) {
        System.out.print(root.data);
        if (root.left != null)
            preorder(root.left);
        if (root.right != null)
            preorder(root.right);
    }

    public void inorder(Node root) {
        if (root.left != null)
            inorder(root.left);
        System.out.print(root.data);
        if (root.right != null)
            inorder(root.right);
    }

    public void postorder(Node root) {
        if (root.left != null) {
            postorder(root.left);
        }
        if (root.right != null) {
            postorder(root.right);
        }
        System.out.print(root.data);
    }
}

public class BOJ1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            tree.createNode(s[0], s[1], s[2]);
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
        System.out.println();
    }
}
