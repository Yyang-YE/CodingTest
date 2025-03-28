import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        // 최소 거리 기준으로 돌기
        int lower = 1;
        int upper = house[N-1] - house[0] + 1;

        while(lower < upper) {
            int mid = (lower + upper) / 2;

            if(getCount(mid) < C) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        System.out.println(lower - 1);
    }

    public static int getCount(int criterion) {
        int count = 1; // 첫번째는 무조건 설치
        int last = house[0];

        for (int i = 1; i < N; i++) {
            // 거리가 기준 이상이면 재설정
            if(house[i] - last >= criterion) {
                count++;
                last = house[i];
            }
        }
        return count;
    }
}
