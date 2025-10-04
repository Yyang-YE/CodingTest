import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;
        int min = 10000;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            total += a;
            if(a % 2 == 1) min = Math.min(min, a);
        }
        System.out.println((total % 2 == 0) ? total : total - ((min == 10000) ? 0 : min));
    }
}
