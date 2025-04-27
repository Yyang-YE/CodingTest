import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        for(int tc = 0; tc < N; tc++) {
            long num = numbers[tc]; // tc마다 확인
            
            // 2진수화
            String biNum = getBinary(num);
            
            Queue<String> queue = new LinkedList<>();
            queue.offer(biNum);
            
            boolean isValid = true;
            while(!queue.isEmpty()) {
                String now = queue.poll();
                
                // 트리 분리
                char root = now.charAt(now.length() / 2);
                String lTree = now.substring(0, now.length() / 2);
                String rTree = now.substring(now.length() / 2 + 1);
                
                if(root == '1') { // 부모 1 : 자식 상관X, leaf가 아닌 경우만 queue에 삽입
                    if(lTree.length() > 1) {
                        queue.offer(lTree);
                        queue.offer(rTree);
                    }
                } else { // 부모 0 : lTree & rTree 전부가 0이어야 함
                    if(lTree.contains("1") || rTree.contains("1")) { // 1있으면
                        isValid = false;
                        break; // 불가니까 검사할 필요X
                    }
                }                
            }
            
            // 정답 입력
            answer[tc] = isValid ? 1 : 0;
        }
        return answer;
    }
    
    // 2^n -1개 (CBT) -> 앞에 0채워서 완전하게 만들기
    public String getBinary(long num) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(num));
        long len = sb.length() - 1L; // 2, 4, 8...을 더한값
        
        long nodeCnt = 2; // 현재 높이의 노드 개수
        while(len > 0) {
            if(len >= nodeCnt) {
                len -= nodeCnt;
                nodeCnt *= 2; // 다음 크기
            } else {
                for(int i = 0; i < nodeCnt - len; i++) {
                    sb.insert(0, "0");
                }
                break;
            }
        }
        return sb.toString();
    }
}