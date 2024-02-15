import java.util.HashMap;

class Solution {
    public int solution(String s) {
        StringBuilder number = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();

        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                answer.append(c);
            } else {
                number.append(c);
                String num = map.get(number.toString());
                if (num != null) {
                    answer.append(num);
                    number.setLength(0);
                }
            }
        }
        return Integer.parseInt(answer.toString());
    }
}