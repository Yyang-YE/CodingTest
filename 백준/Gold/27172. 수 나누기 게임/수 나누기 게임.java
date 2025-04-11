import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int max = 0;

        int[] card = new int[N+1]; // index값이 0인 것과 구분하기 위해
        int[] score = new int[N+1];
        int[] index = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            index[card[i]] = i; // 몇번째 수인지 기록
            max = Math.max(max, card[i]);
        }

        for (int i = 1; i <= N; i++) { // 이거의 배수가 있다면 out
            for (int j = card[i]*2; j <= max; j+= card[i]) {
                if(index[j] > 0) {
                    score[i]++;
                    score[index[j]]--;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(score[i]).append(" ");
        }
        System.out.println(sb);
    }
}
