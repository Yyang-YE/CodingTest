import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int temp = 0;

        Arrays.sort(d);
        for (int i : d) {
            temp += i;
            if(temp > budget) {
                return answer;
            }

            answer++;
        }
        return answer;
    }
}