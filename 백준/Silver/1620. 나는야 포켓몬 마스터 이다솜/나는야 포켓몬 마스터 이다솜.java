import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> dogam = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            dogam.put(String.valueOf(i), name);
            dogam.put(name, String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            bw.write(dogam.get(quiz));
            if(i != M - 1) bw.write("\n");
        }

        br.close();
        bw.close();
    }
}