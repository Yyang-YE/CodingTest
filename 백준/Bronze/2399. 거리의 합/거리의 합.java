import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long total = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                total += Math.abs(arr[i] - arr[j]) * 2L;
            }
        }
        System.out.println(total);
    }
}
