class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    for (int l = 2; l < nums[i]+nums[j]+nums[k]; l++) {
                        if ((nums[i] + nums[j] + nums[k]) % l == 0) {
                            break;
                        }
                        if(l == nums[i] + nums[j] + nums[k]-1) answer++;
                    }
                }
            }
        }
        return answer;
    }
}