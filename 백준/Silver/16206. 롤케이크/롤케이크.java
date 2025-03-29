import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 10으로 나눠떨어지는지, 더 작은지 순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing((Integer n) -> n % 10).thenComparing(n -> n));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int rollCnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num <= 10) {
                if (num == 10) rollCnt++;
                continue;
            }
            // 10 보다 큰 애들만 취급
            pq.offer(num);
        }

        while(M > 0 && !pq.isEmpty()) {
            int len = pq.poll();

            // 1개 더 생김
            if(len == 20) rollCnt++;
            else if(len > 20) pq.offer(len - 10);

            rollCnt++;
            M--;
        }
        System.out.println(rollCnt);
    }
}
