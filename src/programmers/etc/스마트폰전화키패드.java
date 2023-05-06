package programmers.etc;

//18:00 ~
class 스마트폰전화키패드 {
    public String solution(int[] numbers, String hand) {
        int[][] board = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        int left = -1;
        int right = -2;
        String answer = "";
        for(int number : numbers) {
            if(number == 1 || number == 4 || number == 7) {
                left = number;
                answer += "L";
            } else if(number == 3 || number == 6 || number == 9) {
                right = number;
                answer += "R";
            } else {
                int[] mleft = check_distance(left, board);
                int[] mright = check_distance(right, board);
                int[] mnumber = check_distance(number, board);

                int x_l = Math.abs(mleft[0] - mnumber[0]);
                int y_l = Math.abs(mleft[1] - mnumber[1]);

                int x_r = Math.abs(mright[0] - mnumber[0]);
                int y_r = Math.abs(mright[1] - mnumber[1]);

                int res_l = x_l + y_l;
                int res_r = x_r + y_r;
                if(res_l < res_r) {
                    left = number;
                    answer += "L";
                } else if(res_l > res_r) {
                    right = number;
                    answer += "R";
                } else {
                    if(hand.equals("left")) {
                        left = number;
                        answer += "L";
                    } else {
                        right = number;
                        answer += "R";
                    }
                }
            }
        }

        return answer;
    }
    static int[] check_distance(int cur, int[][] board) {
        int[] tmp = new int[2];
        if(cur == -1) {
            tmp[0] = 3;
            tmp[1] = 0;
            return tmp;
        } else if(cur == -2) {
            tmp[0] = 3;
            tmp[1] = 2;
            return tmp;
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == cur) {
                    tmp[0] = i;
                    tmp[1] = j;
                    return tmp;
                }
            }
        }
        return tmp;
    }
}