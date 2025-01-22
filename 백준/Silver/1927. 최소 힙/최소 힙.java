import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                bw.write(minHeap.isEmpty() ? "0" : String.valueOf(minHeap.poll()));
                bw.write("\n");
            } else {
                minHeap.add(x);
            }
        }

        br.close();
        bw.close();
    }
}