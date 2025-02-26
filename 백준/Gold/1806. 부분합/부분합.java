import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;
        int ps = 0;
        int sum = 0;
        for (int pl = 0; pl < N; pl++) {
            sum += arr[pl];
            int temp = ps;

            if(sum >= S) {
                // ps 위치 재조정
                for (int i = temp; i <= pl; i++) {
                    minLength = Math.min(minLength, pl-ps+1);
                    sum -= arr[ps];
                    ps++;
                    if(sum < S) break;
                }
            }
        }
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
