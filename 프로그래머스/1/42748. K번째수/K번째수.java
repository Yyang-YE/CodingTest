import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0]-1; j <= commands[i][1]-1; j++) {
                temp.add(array[j]);
            }
            Collections.sort(temp);
            answer[i] = temp.get(commands[i][2]-1);
            temp.clear();
        }
        return answer;
    }
}