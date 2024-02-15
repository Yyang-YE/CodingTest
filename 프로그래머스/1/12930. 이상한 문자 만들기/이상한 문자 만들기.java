class Solution {
    public String solution(String s) {
        String answer = "";
        int blank = 0;

        for(String str:s.split(" ")) {
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' ') {
                    answer += " ";
                    blank ++;
                } else if ((i-blank) % 2 == 0){
                    answer += (str.charAt(i)<'A' || str.charAt(i) > 'Z') ? (char)(str.charAt(i)-32) : str.charAt(i);
                } else {
                    answer += (str.charAt(i)<'a' || str.charAt(i) > 'z') ? (char)(str.charAt(i)+32) : str.charAt(i);
                }
            }
            answer += " ";
        }
        for (int i = s.length()-1; i > 0; i--) {
            if(s.charAt(i) != ' ') {
                break;
            } else {
                answer += " ";
            }
        }
        return answer.substring(0, answer.length()-1);
    }
}