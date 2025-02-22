import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        String[] map = new String[N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 가로확인
                if(j+D <= M && !map[i].substring(j, j+D).contains("#")) {
                    count++;
                }

                // 세로 확인
                if(i+D > N) continue;
                boolean flag = true;
                for (int k = i; k < i+D; k++) {
                    if (map[k].charAt(j) == '#') {
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
            }
        }
        System.out.println(count);
    }
}
