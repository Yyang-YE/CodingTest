import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        // 1. 소문자 치환
        new_id = new_id.toLowerCase();

        // 2. 기타 제거
        for(char c : new_id.toCharArray()) {
            if(('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        new_id = sb.toString();
        
        // 3. 연속 . 제거
        while(new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        
        // 4. 맨 앞/뒤 제거
        if(new_id.length() != 0 && new_id.charAt(0) == '.') new_id = new_id.substring(1);
        if(new_id.length() != 0 && new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);
        
        // 5. 빈 문자열이면 'a' 대입
        if(new_id.length() == 0) new_id = "a";
        
        // 6. 16자 이상이면 뒷부분 제거, . 제거
        if(new_id.length() >= 15) {
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // 7. 2글자 이하면, 마지막 글자 반복해서 넣기
        while(new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        
        return new_id;
    }
}