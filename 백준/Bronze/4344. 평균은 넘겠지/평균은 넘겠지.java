import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());
        for (int t = 0; t < C; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int total = 0;
            int[] score = new int[N];

            for (int i = 0; i < N; i++) {
                score[i] = Integer.parseInt(st.nextToken());
                total += score[i];
            }

            double mid = (double) total / N;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if(mid < score[i]) count++;
            }
            double res = (double) count / N * 100;
            bw.write(String.format("%.3f%%\n", res));
        }
        br.close();
        bw.close();
    }
}
