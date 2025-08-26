import java.util.*;

class Solution {
    public int solution(int[] cards) {
        // num, 정보
        PriorityQueue<Info> infos = new PriorityQueue<>(Comparator.comparingInt((Info i) -> i.score).reversed());
        
        // 점수 계산
        int N = cards.length;
        for (int i = 1; i <= N; i++) {
            int score = 0;
            int curBox = i;

            boolean[] visited = new boolean[N];
            List<Integer> openList = new ArrayList<>();            

            while(true) {
                score++;
                openList.add(curBox);
                visited[curBox - 1] = true;
                
                // 다음 박스 설정
                curBox = cards[curBox - 1];
                
                // 박스가 열려있으면 끝
                if(visited[curBox - 1]) break;
            }
            infos.offer(new Info(i, (score == N ? 0 : score), openList));
        }
        
        int score = 1;
        List<Integer> list = new ArrayList<>();
        
        int count = 0;
        boolean isFull = true;
        while(count < 2 && !infos.isEmpty()) {
            Info info = infos.poll();
            if(info.score > 0) isFull = false;

            if(info.score == 0 || list.contains(info.idx)) continue;
            
            list.addAll(info.openList);
            score *= info.score;
            count++;
        }
        return isFull ? 0 : score;
    }
    
    public class Info {
        int idx;
        int score;
        List<Integer> openList;
        
        public Info(int idx, int score, List<Integer> openList) {
            this.idx = idx;
            this.score = score;
            this.openList = openList;
        }
    }
}