import java.util.*;

class Solution {
    public static int[] solution(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        int[] result = new int[set.size()];
        int temp = 0;
        for (Integer i : set) {
            result[temp] = i;
            temp++;
        }
        Arrays.sort(result);

        return result;
    }
}