import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparing((Info i) -> i.score).reversed());

        for (int i = 1; i <= 8; i++) {
            pq.offer(new Info(Integer.parseInt(br.readLine()), i));
        }

        int total = 0;
        int[] ans = new int[5];
        for (int i = 0; i < 5; i++) {
            Info info = pq.poll();
            total += info.score;
            ans[i] = info.idx;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(total).append("\n");

        Arrays.sort(ans);
        for (int i = 0; i < 5; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static class Info {
        int score;
        int idx;
        public Info(int score, int idx) {
            this.score = score;
            this.idx = idx;
        }
    }
}
