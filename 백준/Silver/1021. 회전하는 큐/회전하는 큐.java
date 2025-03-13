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
        int M = Integer.parseInt(st.nextToken());

        int[] need = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int count = 0;
        for (int n : need) {
            while(true) {
                // 발견한 경우
                if(deque.peek() == n){
                    deque.poll();
                    break;
                } else {
                    if(deque.indexOf(n) <= deque.size()/2) {
                        while(deque.peek() != n) {
                            deque.offerLast(deque.pollFirst());
                            count++;
                        }
                    } else {
                        while(deque.peek() != n) {
                            deque.offerFirst(deque.pollLast());
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
