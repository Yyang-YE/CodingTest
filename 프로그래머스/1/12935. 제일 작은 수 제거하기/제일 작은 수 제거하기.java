import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        int min = 0;
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        if(arr.length == 1) {
            answer.add(-1);
            return answer;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < arr[min]) {
                min = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(i != min) {
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}