import java.util.ArrayList;

class Solution {
    public int solution(int num) {
        ArrayList<Integer> three = new ArrayList<Integer>();
        int answer = 0;

        while(num != 0) {
            three.add(num % 3);
            num = num / 3;
        }
        for (int i = 0; i < three.size(); i++) {
            answer += three.get(three.size() - i - 1) * Math.pow(3, i);
        }
        
        return answer;
    }
}