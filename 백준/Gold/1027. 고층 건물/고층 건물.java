import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] building;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        building = new int[N];
        for (int i = 0; i < N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        // 각 건물에서 보이는 건물 개수 구하기
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            maxCount = Math.max(maxCount, getCount(i));
        }
        System.out.println(maxCount);
    }

    public static int getCount(int idx) {
        int count = 0;
        double inclination = 0;

        // 왼쪽 확인 : 기울기가 점진적으로 감소
        for (int i = idx - 1; i >= 0; i--) {
            double tmp = (double) (building[idx] - building[i]) / (idx - i);

            if(i == idx - 1 || inclination > tmp) {
                count++;
                inclination = tmp; // 기울기 최소 관리
            }
        }

        // 오른쪽 확인 : 기울기가 점진적으로 증가
        for (int i = idx + 1; i < N; i++) {
            double tmp = (double) (building[idx] - building[i]) / (idx - i);

            if(i == idx + 1 || inclination < tmp) {
                count++;
                inclination = tmp; // 기울기 최대 관리
            }
        }
        return count;
    }
}
