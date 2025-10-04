import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long total = 0;
        long sum1 = 0;
        for(int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            total += queue1[i] + queue2[i];
        }
        
        // 홀수면 불가능
        if(total % 2 != 0) return -1;
        
        // 짝수면 탐색
        int standard = (q1.size() + q2.size()) * 2;
        long target = total / 2;
        int answer = 0;
        
        while(sum1 != target) {
            if(answer++ > standard) return -1;
            
            if(sum1 < target) {
                int n = q2.poll();
                q1.offer(n);
                sum1 += n;
            } else {
                int n = q1.poll();
                q2.offer(n);
                sum1 -= n;
            }
        }
        return answer;
    }
}