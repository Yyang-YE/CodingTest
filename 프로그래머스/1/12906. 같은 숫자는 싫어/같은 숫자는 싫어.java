import java.util.*;

public class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(i != 0) {
                if(arr[i-1] != arr[i]) {
                    answer.add(arr[i]);
                }
            } else {
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}