package syntax;

public class Combination {
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) {
        int n = 4;
        arr = new int[n];
        visited = new boolean[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;

        combination(0, 4, 2);
    }
    static void combination(int start, int n, int r) {
        if(r == 0) {
            for (int i = 0; i < n; i++) {
                if(visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
