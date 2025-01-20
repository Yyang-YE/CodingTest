import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        Map<String, String> memo = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] mem = br.readLine().split(" ");
            memo.put(mem[0], mem[1]);
        }

        for (int i = 0; i < M; i++) {
            bw.write(memo.get(br.readLine()));
            if(i != M - 1) bw.write('\n');
        }
        br.close();
        bw.close();
    }
}