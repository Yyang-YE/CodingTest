import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] gems;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int lower = 1;
        int upper = 0;

        gems = new int[M];
        for (int i = 0; i < M; i++) {
            gems[i] = Integer.parseInt(br.readLine());
            upper = Math.max(upper, gems[i]);
        }

        while(lower < upper) {
            int mid = (lower + upper) / 2;
            int count = getCount(mid);

            if(count > N) lower = mid + 1;
            else upper = mid;
        }
        System.out.println(lower);
    }

    public static int getCount(int criterion) {
        int count = 0;
        for (int i = 0; i < M; i++) {
            if(gems[i] % criterion != 0) count++;
            count += gems[i] / criterion;
        }
        return count;
    }
}
