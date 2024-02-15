class Solution {
    public int solution(int a, int b, int n) {
        int left = 0;
        int answer = 0;

        while(n >= a) {
            left = n % a;
            answer += n / a * b;
            n = n / a * b + left;
        }
        return answer;
    }
}