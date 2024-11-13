import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(scores);

        int cut = (int) Math.round(N * 0.15);
        int sum = 0;
        for (int i = cut; i < N - cut; i++) {
            sum += scores[i];
        }

        System.out.println(Math.round((float) sum / (N - 2 * cut)));
    }
}