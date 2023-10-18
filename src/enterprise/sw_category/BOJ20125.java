package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ20125 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[][] board = new String[n][n];

        int headX = -1;
        int headY = -1;
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < s.length; j++) {
                board[i][j] = s[j];
                if(board[i][j].equals("*") && headX == -1 && headY == -1) {
                    headX = i;
                    headY = j;
                }
            }
        }

        // 왼쪽 팔
        int leftX = headX + 1;
        int leftY = headY - 1;
        int leftArmCnt = 0;
        while(true) {
            if(board[leftX][leftY].equals("*")) {
                leftArmCnt++;
                leftY--;
            } else { break;}
            if(!isRange(leftX, leftY)) break;
        }
        // 오른쪽 팔
        int rightX = headX + 1;
        int rightY = headY + 1;
        int rightArmCnt = 0;
        while(true) {
            if(board[rightX][rightY].equals("*")) {
                rightArmCnt++;
                rightY++;
            } else { break;}
            if(!isRange(rightX, rightY)) break;
        }
        // 허리
        int centerX = headX + 2;
        int centerY = headY;
        int centerArmCnt = 0;
        while(true) {
            if(board[centerX][centerY].equals("*")) {
                centerArmCnt++;
                centerX++;
            } else { break;}
            if(!isRange(centerX, centerY)) break;
        }
        // 왼쪽 다리
        int leftLegX = centerX;
        int leftLegY = centerY - 1;
        int leftLegCnt = 0;
        while(true) {
            if(board[leftLegX][leftLegY].equals("*")) {
                leftLegCnt++;
                leftLegX++;
            } else { break;}
            if(!isRange(leftLegX, leftLegY)) break;
        }
        // 오른쪽 다리의 길이
        int rightLegX = centerX;
        int rightLegY = centerY + 1;
        int rightLegCnt = 0;
        while(true) {
            if(board[rightLegX][rightLegY].equals("*")) {
                rightLegCnt++;
                rightLegX++;
            } else { break;}
            if(!isRange(rightLegX, rightLegY)) break;
        }
        System.out.println((headX + 2) + " " + (headY + 1));
        System.out.println(leftArmCnt + " " + rightArmCnt + " " + centerArmCnt + " " + leftLegCnt + " " + rightLegCnt);
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
