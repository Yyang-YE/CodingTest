import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, min, answer;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        scores = new int[N];

        int upper = 0; // 전체 총합
        int lower = 21; // 최솟값
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            scores[i] = num;
            upper += num;
            lower = Math.min(lower, num);
        }

        if(N == K) answer = lower; // 그룹 당 1개씩
        else if (K == 1) answer = upper; // 전체를 하나에 넣기
        else calculate(lower, upper);

        System.out.println(answer);
    }

    public static void calculate(int lower, int upper) {
        while(lower < upper) {
            int mid = (lower + upper) / K;
            int count = getCount(mid);

            if(count == K) {
                answer = Math.max(min, answer);
                break;
            } else if(count < K){
                upper -= K;
            } else {
                lower += K;
            }
        }
    }

    // 최소 criterion보다는 크다!!! 모든 합이
    public static int getCount(int criterion) {
        min = Integer.MAX_VALUE;
        int tmpSum = 0;
        int count = 0;

        // 끊어가면서 돌기
        for (int i = 0; i < N; i++) {
            if(tmpSum < criterion) {
                tmpSum += scores[i];
                continue;
            }
            // criterion보다 크거나 같으면 끝
            count++;
            min = Math.min(min, tmpSum);
            tmpSum = scores[i];
        }

        // 나머지가 있는 경우
        if(tmpSum >= criterion) {
            min = Math.min(min, tmpSum);
            count++;
        }
        return count;
    }
}
