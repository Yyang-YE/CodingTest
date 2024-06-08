class Solution {
    public static int solution(String s) {
            int answer = 0;
        char x = s.charAt(0);
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                answer++;
                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1);
                }
            }
        }
        
        if (balance != 0) {
            answer++;
        }

        return answer;
    }


}