package samsungSW.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class SW5215
{
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++) {
            String[] s = br.readLine().split(" ");

            int answer = 0;
            int n = Integer.parseInt(s[0]);
            int l = Integer.parseInt(s[1]);

            int[][] board = new int[n + 1][2];
            int[][] dp = new int[n + 1][l + 1];

            for(int i = 0; i < n; i++) {
                s = br.readLine().split(" ");
                board[i + 1][0] = Integer.parseInt(s[0]); // 점수
                board[i + 1][1] = Integer.parseInt(s[1]); // 칼로리
            }

            // dp[i][j]
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j <= l; j++) {
                    // 1번 케이스: 햄버거 고름
                    // 2번 케이스: 햄버거 안고름
                    if(j - board[i][1] >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - board[i][1]] + board[i][0]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    answer = Math.max(answer, dp[i][j]);
                }
            }

            System.out.printf("#%d %d\n", test_case, dp[n][l]);
        }
    }
    static boolean isRange(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
