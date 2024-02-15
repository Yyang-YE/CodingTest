class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if(Math.pow((int)Math.sqrt(i), 2) == i) {
                answer -= i;
                System.out.println("제곱수: " + i);
            } else {
                answer += i;
                System.out.println("짝수: " + i);
            }
        }
        return answer;
    }
}