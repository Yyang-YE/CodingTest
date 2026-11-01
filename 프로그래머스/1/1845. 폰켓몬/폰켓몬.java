import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int count = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums) {
            set.add(n);
        }
        return Math.min(count, set.size());
    }
}