import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static int[] tanghuru;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        tanghuru = new int[N];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            tanghuru[i] = num;
            set.add(num);
        }
        if(set.size() <= 2) max = N;
        else getMax();
        System.out.println(max);
    }

    public static void getMax() {
        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        for (int r = 0; r < N; r++) {
            map.put(tanghuru[r], map.getOrDefault(tanghuru[r], 0) + 1);

            while(map.size() > 2) {
                map.put(tanghuru[l], map.get(tanghuru[l]) - 1);
                if(map.get(tanghuru[l]) == 0) map.remove(tanghuru[l]);
                l++;
            }
            max = Math.max(max, r-l+1);
        }
    }
}
