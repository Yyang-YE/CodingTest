import java.lang.Math;

class Solution {
    public long solution(long n) {
         if(Math.sqrt(n) == (long)Math.sqrt(n)) {
             return (long)Math.pow(Math.sqrt(n)+1, 2);
        } else {
            return -1;
        }
    }
}