import java.util.*;

class Solution {
    static int N, max;
    static int[] A, B; // 선택된 값
    static boolean[] selected;
    static int[] answer;
    static int[][] dice;
    public int[] solution(int[][] diceInfo) {
        // 초기화
        N = diceInfo.length;
        answer = new int[N/2];
        A = new int[N/2];
        B = new int[N/2];
        selected = new boolean[N];
        
        dice = diceInfo;
        
        // 주사위 고르기
        pickDice(0, 0);
        // idx 맞춰주기
        for(int i = 0; i < answer.length; i++) answer[i]++;
        return answer;
    }
    
    public void pickDice(int idx, int depth) {
        if(depth == N / 2) {
            // 이걸 선택한 경우의 A 승리 count
            int adx = 0, bdx = 0; // idx 설정
            for(int i = 0; i < N; i++) {
                if(selected[i]) A[adx++] = i;
                else B[bdx++] = i;
            }

            int winCnt = getWin(); // selected 값 업데이트
            
            // 정답 업데이트
            if(max < winCnt) {
                max = winCnt;
                answer = A.clone();
            }
            return;
        }
        
        for(int i = idx; i < N; i++) {
            selected[i] = true;
            pickDice(i+1, depth+1);
            selected[i] = false;
        }
    }
    
    public int getWin() {
        // 얕은 복사-> 주소 넘겨서 결과 저장
        List<Integer> Asums = new ArrayList<>();
        getSums(A, 0, 0, Asums);
        List<Integer> Bsums = new ArrayList<>();
        getSums(B, 0, 0, Bsums);

        Collections.sort(Bsums);
        
        int wins = 0;
        for(int i : Asums) {
            wins += getMinCount(Bsums, i); // i보다 작은 개수
        }
        return wins;
    }
    
    // sums들의 전체 경우의수를 return
    public void getSums(int[] idxs, int depth, int sum, List<Integer> result) {
        if(depth == N/2) {
            result.add(sum);
            return;
        }
        
        int idx = idxs[depth];
        for (int num : dice[idx]) {
            getSums(idxs, depth+1, sum+num, result);
        }
    }
    
    // 이분탐색
    public int getMinCount(List<Integer> list, int target) {
        int ps = 0;
        int pl = list.size()-1;
        
        while(ps <= pl) {
            int mid = (ps + pl) / 2;
            if(target <= list.get(mid)) pl = mid-1;
            else ps = mid + 1;
        }
        return pl+1;
    }
}