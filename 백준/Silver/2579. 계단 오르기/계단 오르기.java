import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] stairs;
    static int[][] maxPoint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        stairs = new int[N];
        maxPoint = new int[N][2];

        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        countPoint(N-1);

        System.out.println(Math.max(maxPoint[N-1][0], maxPoint[N-1][1]));
    }

    public static void countPoint(int step) {
        if(step == 0) {
            maxPoint[step][0] = maxPoint[step][1] =  stairs[step];
            return;
        } else if(step == 1) {
            countPoint(0);
            maxPoint[step][0] = maxPoint[0][0] + stairs[step];
            maxPoint[step][1] = stairs[step];

            return;
        }

        countPoint(step-1);
        maxPoint[step][0] = maxPoint[step-1][1] + stairs[step];
        maxPoint[step][1] = Math.max(maxPoint[step-2][0], maxPoint[step-2][1]) + stairs[step];
    }
}
