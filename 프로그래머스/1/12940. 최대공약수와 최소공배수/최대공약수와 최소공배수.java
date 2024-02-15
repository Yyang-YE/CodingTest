class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int temp;
        int msave = m, nsave = n;

        //최대공약수
        while (m != 0) {
            temp = m;
            m = n % m;
            n = temp;
        }
        answer[0] = n;

        //최대공배수
        answer[1] = (msave * nsave) / n;

        
        return answer;
    }
}