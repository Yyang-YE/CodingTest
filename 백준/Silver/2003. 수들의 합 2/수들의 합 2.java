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
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startPointer = 0;
        int endPointer = 0;
        int sum = arr[0];
        int count = 0;
        while(true) {
            if(sum > M) {
                if(startPointer == endPointer) {
                    endPointer++;
                    if (endPointer == N) break;
                    sum += arr[endPointer];
                } else {
                    sum -= arr[startPointer];
                    startPointer++;
                }
            } else {
                if(sum == M) count++;
                endPointer++;
                if (endPointer == N) break;
                sum += arr[endPointer];
            }
        }
        System.out.println(count);
    }
}
