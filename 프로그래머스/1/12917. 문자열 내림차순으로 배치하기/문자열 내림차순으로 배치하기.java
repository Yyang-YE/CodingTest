import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        String answer = "";

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            answer += arr[arr.length - i - 1];
        }
        return answer;
    }
}