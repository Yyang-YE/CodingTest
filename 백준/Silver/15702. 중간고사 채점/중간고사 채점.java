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

        int[] score = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        int topStd = 101;
        int maxScore = -1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int stdNum = Integer.parseInt(st.nextToken());
            int stdScore = 0;
            for (int j = 0; j < N; j++) {
                if(st.nextToken().equals("O")) stdScore += score[j];
            }

            if(maxScore < stdScore || (maxScore == stdScore && topStd > stdNum)) {
                topStd = stdNum;
                maxScore = stdScore;
            }
        }
        System.out.println(topStd + " " + maxScore);
    }
}
