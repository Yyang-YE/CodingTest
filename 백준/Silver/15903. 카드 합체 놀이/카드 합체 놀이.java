import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Long total = 0L;
        List<Long> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            total += num;
            list.add(num);
        }
        PriorityQueue<Long> pq = new PriorityQueue<>(list);

        for (int i = 0; i < M; i++) {
            long a = pq.poll();
            long b = pq.poll();

            pq.add(a+b);
            pq.add(a+b);
            // a는 b만큼, b는 a만큼 증가함
            total += a+b;
        }
        System.out.println(total);
    }
}
