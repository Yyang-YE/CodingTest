import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int sT = n * s;
            int pT = d + (n * p);
            sb.append((sT == pT) ? "does not matter\n" : ((sT > pT) ? "parallelize\n" : "do not parallelize\n"));
        }
        System.out.println(sb);
    }
}
