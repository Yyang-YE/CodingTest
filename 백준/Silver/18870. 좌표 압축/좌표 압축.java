import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] xs = new int[N];
        int[] sorted = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            xs[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int count = 0;
        for (int v : sorted) {
            if(!map.containsKey(v)) {
                map.put(v, count);
                count++;
            }
        }

        for (int i = 0; i < N; i++) {
            bw.append(String.valueOf(map.get(xs[i])));
            if(i != N-1) bw.append(" ");
        }

        bw.close();
        br.close();
    }
}
