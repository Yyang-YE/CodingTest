class Solution {
    public boolean solution(int x) {
        int sum = 0;
        boolean answer = false;

        for(char c :Integer.toString(x).toCharArray()) {
            sum += Character.getNumericValue(c);
        }

        if(x % sum == 0) {
            answer = true;
        }
        return answer;
    }
}