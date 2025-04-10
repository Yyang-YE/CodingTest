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

        int minPack = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minPack = Math.min(minPack, Integer.parseInt(st.nextToken()));
            minOne = Math.min(minOne, Integer.parseInt(st.nextToken()));
        }
        int minCost = Math.min(minPack*(N/6) + minOne*(N%6), minPack * (N/6 + 1));
        minCost = Math.min(minCost, N * minOne);
        System.out.println(minCost);
    }
}
