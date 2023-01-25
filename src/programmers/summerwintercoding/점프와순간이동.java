package programmers.summerwintercoding;

public class 점프와순간이동 {
    static int n;
    static int res = Integer.MAX_VALUE;
    public static int solution(int n) {
        int ans = 0;
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }


        return ans;
    }
    public static void main(String[] args) {
        n = 5000;
//        int n = 6;
//        int n = 5000;
        System.out.println(solution(n));
    }
}
