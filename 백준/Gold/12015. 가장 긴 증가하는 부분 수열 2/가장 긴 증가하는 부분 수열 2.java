import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0];
        int len = 1;

        for (int i = 1; i < N; i++) {
            int key = arr[i]; // 새로 넣을 값

            if(LIS[len-1] < key) { // 마지막 원소보다 크면 추가
                LIS[len] = key;
                len++;
            } else { // 이분탐색 실행
                int low = 0;
                int up = len;
                while(low < up) {
                    int mid = (low + up) / 2;
                    if(LIS[mid] < key) {
                        low = mid + 1;
                    } else {
                        up = mid;
                    }
                }
                LIS[low] = key;
            }
        }
        System.out.println(len);
    }
}
