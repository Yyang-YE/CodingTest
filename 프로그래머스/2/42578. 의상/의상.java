import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> closet = new HashMap<>();

        for (String[] cloth : clothes) {
            String key = cloth[1];
            if (!closet.containsKey(key)) {
                closet.put(key, 2); // 안입는 경우도 추가
            } else {
                closet.put(key, closet.get(key) + 1);
            }
        }

        int result = 1;
        for (String type : closet.keySet()) {
            result *= closet.get(type);
        }
        return result - 1;
    }
}