import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] left = new int[K+1];
        int[] right = new int[K+1];
        for (int i = 0; i < X * 2; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(i < X) left[a]++;
            else right[a]++;
        }

        long answer = 0;
        for (int i = 1; i <= K; i++) {
            if(left[i] == 0) continue;
            answer += (long) left[i] * (X - right[i]);
        }
        System.out.println(answer);
    }
}
