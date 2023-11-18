package syntax;
import java.util.*;
import java.io.*;

public class syntax_test {

    static int[] parent;

    public static void main(String[] args) {
        int n = 3; // 노드의 개수
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 각 노드의 부모 노드를 자신으로 초기화
        }

        union(0, 2);
        union(1, 2);

        if (find(0) == find(1)) {
            System.out.println("노드 0과 노드 1은 같은 신장 트리에 속해있습니다.");
        } else {
            System.out.println("노드 0과 노드 1은 다른 신장 트리에 속해있습니다.");
        }
        System.out.println(Arrays.toString(parent));
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}