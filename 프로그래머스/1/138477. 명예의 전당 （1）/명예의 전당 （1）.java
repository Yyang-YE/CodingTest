import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        ArrayList<Integer> honor = new ArrayList<Integer>();
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            honor.add(score[i]);
            Collections.sort(honor);

            if(i < k) {
                answer[i] = honor.get(0);
            } else {
                answer[i] = honor.get(honor.size() - k);
            }
        }        return answer;
    }
}