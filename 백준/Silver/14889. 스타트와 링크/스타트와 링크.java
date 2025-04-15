import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] score = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << N); i++) { // 케이스마다
            if(Integer.bitCount(i) != N/2) continue;
            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                // 0: start, 1: link
                if((i & (1 << j)) == 0) start.add(j);
                else link.add(j);
            }

            // start 합 구하기
            int startSum = 0;
            for (int j = 0; j < start.size()-1; j++) {
                for (int k = j + 1; k < start.size(); k++) {
                    startSum += score[start.get(j)][start.get(k)] + score[start.get(k)][start.get(j)];
                }
            }

            // link 합 구하기
            int linkSum = 0;
            for (int j = 0; j < link.size()-1; j++) {
                for (int k = j + 1; k < link.size(); k++) {
                    linkSum += score[link.get(j)][link.get(k)] + score[link.get(k)][link.get(j)];
                }
            }
            min = Math.min(min, Math.abs(startSum - linkSum));
        }
        System.out.println(min);
    }
}
