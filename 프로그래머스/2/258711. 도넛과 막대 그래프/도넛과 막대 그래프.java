import java.util.*;

class Solution {
    static int N = 1000000;
    static int[] out = new int[N+1];
    static int[] in = new int[N+1];
    public int[] solution(int[][] edges) {
        int[] answer = new int[4]; // 0: 루트, 1: 도넛, 2: 막대, 3: 8자
        
        for(int[] e : edges) {
            out[e[0]]++;
            in[e[1]]++;
        }
        
        for(int i = 1; i <= N; i++) {
            if(in[i] == 0 && out[i] >= 2) { // root
                answer[0] = i;
            } else if(in[i] > 0 && out[i] == 2) { // 8자
                answer[3]++;
            } else if(in[i] > 0 && out[i] == 0) { // 막대
                answer[2]++;
            }
        }
        
        // root의 out 수 == 전체 그래프 개수
        answer[1] = out[answer[0]] - answer[2] - answer[3];
        return answer;
    }
}