import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int m : moves) {
            for (int[] b : board) {
                int curNum = b[m-1];
                if(curNum != 0) {
                    if(!stack.isEmpty() && stack.peek() == curNum) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(curNum);
                    }
                    b[m-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}