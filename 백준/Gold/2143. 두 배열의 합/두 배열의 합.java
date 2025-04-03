import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Map<Long, Long> mapA = getMap(A, N);
        Map<Long, Long> mapB = getMap(B, M);

        long count = 0;
        for (Long a : mapA.keySet()) {
            long b = mapB.getOrDefault(T-a, 0L);
            count += (mapA.get(a) * b);
        }
        System.out.println(count);
    }

    public static Map<Long, Long> getMap(int[] arr, int size) {
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            long sum = 0;
            for (int j = i; j < size; j++) {
                sum += arr[j];
                long cnt = map.getOrDefault(sum, 0L);
                map.put(sum, cnt+1);
            }
        }
        return map;
    }
}
