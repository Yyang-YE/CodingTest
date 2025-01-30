import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<NumClass> pq = new PriorityQueue<>(
            Comparator.comparingInt((NumClass o) -> o.num)
                .thenComparing(o -> !o.isNegative)); // 음수가 더 높은 우선순위
        
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int curNum = Integer.parseInt(br.readLine());

            if(curNum == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                }else {
                    NumClass nc = pq.poll();
                    int resNum = nc.isNegative ? nc.num * -1 : nc.num;
                    sb.append(resNum).append("\n");
                }
            } else {
                pq.add(new NumClass(curNum));
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
    
    public static class NumClass {
        int num;
        boolean isNegative;
        
        NumClass(int number) {
            if(number > 0) {
                this.num = number;
                this.isNegative = false;
            } else { // 음수면 양으로 바꾼 후 저장
                this.num = number * (-1);
                this.isNegative = true;
            }
        }
    }
}