import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        // expr 중 X 있는것, 없는것 구분하기
        List<String> complete = new LinkedList<>();
        List<String> needFill = new LinkedList<>();
        
        int maxNum = 0;
        for(String expr : expressions) {
            if(expr.contains("X")) needFill.add(expr);
            else complete.add(expr);
            String[] info = expr.split(" ");
            int num1 = Integer.parseInt(info[0]);
            int num2 = Integer.parseInt(info[2]);
            int num3 = info[4].equals("X") ? 0 : Integer.parseInt(info[4]);
            
            maxNum = Math.max(maxNum, Math.max(num1 / 10, num1 % 10));
            maxNum = Math.max(maxNum, Math.max(num2 / 10, num2 % 10));
            // 3자리인 경우 고려하기
            maxNum = Math.max(maxNum, Math.max(num3 / 100, Math.max(num3 / 10 % 10 , num3 % 10)));
        }
        System.out.println("maxNum: " + maxNum);
        
        // 가능한 진법 정보 가져오기
        List<Integer> jinbub = checkPossibleJinbub(complete, maxNum);
        System.out.println(Arrays.toString(jinbub.toArray()));

        // 채울 값마다 정리
        String[] answer = new String[needFill.size()];
        for(int i = 0; i < needFill.size(); i++) {
            List<Integer> result = new ArrayList<>(); // 가능한 정답 저장 set
            String[] info = needFill.get(i).split(" ");
            boolean operator = info[1].equals("+") ? true : false;
            
            // 가능한 결과 모두 저장
            for(int j : jinbub) {
                int res = calculate(j, operator, Integer.parseInt(info[0]), Integer.parseInt(info[2]));
                if(!result.contains(res)) {
                    result.add(res);
                    System.out.println(j + " 진법: " + res);
                }
            }
            System.out.println(needFill.get(i) + " : " + Arrays.toString(result.toArray()));

            // 정답 저장
            if(result.size() == 1) { // 하나면 확정답
                answer[i] = needFill.get(i).replace("X", String.valueOf(result.get(0)));
            } else { // 답 여러개면 알 수 없음
                answer[i] = needFill.get(i).replace("X", "?");
            }
        }

        return answer;
    }
    
    // 2~9 중 가능한 진법 확인하기
    public List<Integer> checkPossibleJinbub(List<String> expr, int start) {
        List<Integer> answer = new LinkedList<>();
        
        for(int i = start + 1; i < 10; i++) {
            boolean isAvailable = true;
            for(String e : expr) {
                String[] info = e.split(" ");
                
                int num1 = Integer.parseInt(info[0]);
                int num2 = Integer.parseInt(info[2]);                
                boolean operator = info[1].equals("+") ? true : false; // +: T, -: F
                
                int res = calculate(i, operator, num1, num2);
                
                if(res != Integer.parseInt(info[4])) { // 결과 불일치: 안됨
                    isAvailable = false;
                    break; // 나머지 검사 필요X
                }
            }
            
            // 가능한 진법이면 결과에 추가
            if(isAvailable) {
                answer.add(i);
            }   
        }
        return answer;
    }
    
    // 진법, 연산자, 파람2개 받아서 해당 진법으로 연산 시 결과 반환
    public int calculate(int jinbub, boolean operator, int num1, int num2) {
        // 10진수로 변환해서 계산 -> 원하는 진법으로 재계산
        num1 = toTen(jinbub, num1);
        num2 = toTen(jinbub, num2);
        
        int result = operator ? num1 + num2 : num1 - num2;
        
        return toOriginal(jinbub, result);
    }
    
    // 항상 2자리만 들어옴
    public int toTen(int jinbub, int num) {
        return num % 10 + num / 10 * jinbub;
    }
    
	public int toOriginal(int jinbub, int num) {
		StringBuilder result = new StringBuilder();
        if(num == 0) return 0;

		while(num > 0) {
			int now = num % jinbub;
			num /= jinbub;
			result.append(now);
		}
		return Integer.parseInt(String.valueOf(result.reverse()));
	}
}