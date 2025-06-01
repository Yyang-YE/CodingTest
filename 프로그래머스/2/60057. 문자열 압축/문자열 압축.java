class Solution {
    public int solution(String s) {
        int len = s.length();
        StringBuilder sb;

        int minLen = (s.length() == 1) ? 1 :Integer.MAX_VALUE;
        for(int i = 1; i <= len/2; i++) {
            int start = 0; // 여기부터 쪼개기
            sb = new StringBuilder();
            
            String prefix = "";
            int count = 0;
            while(true) {
                if(s.substring(start).length() >= i) {
                    String cur = s.substring(start, start + i);
                    
                    if(cur.equals(prefix)) {
                        count++;
                    } else {
                        if(start != 0 && count > 1) sb.append(count);
                        sb.append(prefix);
                        
                        prefix = cur;
                        count = 1;
                    }
                    start += i;
                } else {
                    if(start != 0 && count > 1) sb.append(count);
                    sb.append(prefix);
                    sb.append(s.substring(start));
                    break;
                }
            }
            
            if(minLen > sb.length()) {
                minLen = sb.length();
            }
        }
        return minLen;
    }
}