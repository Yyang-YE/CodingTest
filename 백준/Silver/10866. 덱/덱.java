import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num;

            switch (cmd) {
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    deque.offerFirst(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    deque.offerLast(num);
                    break;
                case "pop_front":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.pollFirst()+"\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.pollLast()+"\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "front":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.peekFirst()+"\n");
                    break;
                case "back":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.peekLast()+"\n");
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
