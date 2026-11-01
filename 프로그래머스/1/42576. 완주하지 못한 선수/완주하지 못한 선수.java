import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : completion) {
            if(map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        
        // 제거
        for(String s : participant) {
            if(!map.containsKey(s)) {
                return s;
            }
            
            if(map.get(s) > 1) {
                map.replace(s, map.get(s) - 1);
            } else {
                map.remove(s);
            }
        }

        return answer;
    }
}