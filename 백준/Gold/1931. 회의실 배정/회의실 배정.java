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
        int[][] times = new int[N][2];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int currentTime = 0;
        // 끝나는 시간이 이른 순, 같다면 시작 시간이 이른 순
        Arrays.sort(times, Comparator.comparingInt((int[] time) -> time[1])
            .thenComparingInt(time -> time[0]));

        for (int[] time : times) {
            if(currentTime <= time[0]) {
                currentTime = time[1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}