import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String name : completion) {
            if(map.containsKey(name)) {
                map.replace(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }

        String answer = "";
        for (String name : participant) {
            if(!map.containsKey(name)) {
                return name;
            }

            if(map.get(name) == 1) {
                map.remove(name);
            } else {
                map.replace(name, map.get(name) - 1);
            }
        }
        return answer;
    }
}