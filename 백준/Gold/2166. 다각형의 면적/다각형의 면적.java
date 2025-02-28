import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        points = new long[N+1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        points[N][0] = points[0][0];
        points[N][1] = points[0][1];
        System.out.printf(String.format("%.1f", calculateArea()));
    }

    // 신발끈 공식 : 세 좌표로 삼각형 넓이 구하기
    public static double calculateArea() {
        double temp1 = 0;
        double temp2 = 0;
        for (int i = 0; i < N; i++) {
            temp1 += points[i][0] * points[i+1][1];
            temp2 += points[i+1][0] * points[i][1];
        }
        return Math.abs(temp1 - temp2) / 2;
    }
}
