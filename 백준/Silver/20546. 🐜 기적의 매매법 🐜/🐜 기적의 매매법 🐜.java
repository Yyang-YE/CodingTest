import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cost = new int[14];
        int junMoney = N;
        int junCount = 0;
        int minMoney = N;
        int minCount = 0;

        for (int i = 0; i < 14; i++) {
            cost[i] = Integer.parseInt(st.nextToken());

            // 준현
            junCount += junMoney / cost[i];
            junMoney %= cost[i];

            // 성민
            if (i < 3) continue;
            if (cost[i - 3] < cost[i - 2] && cost[i - 2] < cost[i - 1] && cost[i - 1] < cost[i]) { // 상승
                minMoney += minCount * cost[i];
                minCount = 0;
            } else if (cost[i - 3] > cost[i - 2] && cost[i - 2] > cost[i - 1] && cost[i - 1] > cost[i]) { // 하락
                minCount += minMoney / cost[i];
                minMoney %= cost[i];
            }
        }

        int jun = junMoney + cost[13] * junCount;
        int min = minMoney + cost[13] * minCount;
        System.out.println(jun == min ? "SAMESAME" : (jun > min) ? "BNP" : "TIMING");
    }
}
