class Solution {
    public long solution(long n) {
        long answer = 0;
        char temp;
        char[] arr = Long.toString(n).toCharArray();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            answer = answer * 10 + (arr[i] - '0');
        }
        return answer;
    }
}