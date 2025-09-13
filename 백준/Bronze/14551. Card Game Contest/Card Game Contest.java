import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 1;
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(br.readLine());
            answer *= (A == 0 ? 1 : A);
            answer %= M;
        }
        System.out.println(answer % M);
    }
}
