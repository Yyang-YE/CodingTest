class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        for (int i = section[0]-1; i < n + 1; i++) {
            for(int num:section) {
                if (num == i+1) {
                    i += m-1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}