class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int count = 0;
        for(int num: arr) {
            answer += num;
            count++;
        }
        return answer / count;
    }
}