class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        if(s.length() == 4 || s.length() == 6) {
            for(char c: s.toCharArray()) {
                if(c >= '0' && c <= '9') {
                    answer = true;
                } else {
                    return false;
                }
            }
        }
        return answer;
    }
}