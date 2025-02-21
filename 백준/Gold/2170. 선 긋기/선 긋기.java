import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] lines = new long[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작점을 기준으로 정렬
        Arrays.sort(lines, Comparator.comparing(l -> l[0]));
        
        long answer = 0;
        long start = lines[0][0];
        long end = lines[0][1];
        for (int i = 1; i < N; i++) {
            // start 기준 바꾸기
            if(end < lines[i][0]) {
                answer += (end - start);
                start = lines[i][0];
            }

            // end 기준바꾸기
            if(end < lines[i][1]) {
                end = lines[i][1];
            }
        }
        answer += (end - start);
        System.out.println(answer);
    }
}
