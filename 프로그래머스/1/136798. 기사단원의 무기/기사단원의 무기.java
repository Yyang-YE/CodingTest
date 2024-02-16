class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] yaksu = new int[number];

        for (int i = 1; i <= number; i++) {
            yaksu[i-1] = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if(Math.pow(j, 2) == i) {
                    yaksu[i-1] += 1;
                } else if(i % j == 0){
                    yaksu[i-1] += 2;
                }
            }
            if(yaksu[i-1] > limit) {
                yaksu[i-1] = power;
            }
            answer += yaksu[i-1];
        }
        return answer;
    }
}