class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(String bab : babbling) {
            if(bab.contains("ayaaya") || bab.contains("yeye") || bab.contains("woowoo") || bab.contains("mama")) {
                continue;
            }
            bab = bab.replaceAll("aya", " ").replaceAll("ye", " ").replaceAll("woo", " ").replaceAll("ma", " ");
            if (bab.replaceAll(" ", "").length() == 0) {
                answer++;
            }
        }

        return answer;
    }
}