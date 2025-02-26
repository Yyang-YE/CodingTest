import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == 1) {
                deque.add(i);
                if(deque.size() >= K) {
                    minSize = Math.min(minSize, (deque.peekLast() - deque.peekFirst() + 1));
                    deque.poll();
                }
            }
        }
        System.out.println(minSize == Integer.MAX_VALUE ? -1 : minSize);
    }
}
