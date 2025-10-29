import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                dq.offerFirst(Integer.parseInt(st.nextToken()));
            } else if(cmd == 2) {
                dq.offerLast(Integer.parseInt(st.nextToken()));
            } else if(cmd == 3) {
                sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n");
            } else if(cmd == 4) {
                sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n");
            } else if(cmd == 5) {
                sb.append(dq.size()).append("\n");
            } else if(cmd == 6) {
                sb.append(dq.isEmpty() ? 1 : 0).append("\n");
            } else if(cmd == 7) {
                sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
            } else {
                sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}