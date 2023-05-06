package programmers.etc;

import java.util.*;
import java.io.*;

class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(null);
        System.out.println(arr.get(0));
    }
    static Stack<Integer> stack;
    static int total = 0;

    public int solution(int[][] board, int[] moves) {

        stack = new Stack<>();
        stack.push(0);

        int len = board.length;
        for (int move : moves) {
            board = find(move - 1, board, len);
        }

        int answer = 0;
        return total;
    }
    //1,5,3,5,1,2,1,4]

    /**
     * [0,0,0,0,0]
     * [0,0,1,0,3]
     * [0,2,5,0,1]
     * [4,2,4,4,2]
     * [3,5,1,3,1]
     **/
    static int[][] find(int move, int[][] board, int len) {
        for (int i = 0; i < len; i++) {
            if (board[i][move] == 0) continue;
            if (stack.peek() != (board[i][move])) {
                stack.push(board[i][move]);
            } else {
                total += 2;
                stack.pop();
            }
            board[i][move] = 0;
            // System.out.println(stack);
            return board;
        }

        return board;
    }
}

/**
 * class Solution {
 *     static ArrayList<Integer> arr;
 *     static int total = 0;
 *     public int solution(int[][] board, int[] moves) {
 *
 *         arr = new ArrayList<>();
 *         arr.add(-1);
 *         int len = board.length;
 *         for(int move : moves) {
 *             board = find(move - 1, board, len);
 *         }
 *
 *         int answer = 0;
 *         return total;
 *     }
 *     static int[][] find(int move, int[][] board, int len) {
 *         for(int i = 0; i < len; i++) {
 *             if(board[i][move] == 0) continue;
 *             if(arr.get(arr.size() - 1) != board[i][move]) {
 *                 arr.add(board[i][move]);
 *             } else {
 *                 arr.remove(arr.size() - 1);
 *                 total += 2;
 *             }
 *             board[i][move] = 0;
 *             // System.out.println(arr);
 *             return board;
 *         }
 *
 *         return board;
 *     }
 * }
 */