import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int R = Integer.parseInt(br.readLine());
        char[] sang = br.readLine().toCharArray();

        int N = Integer.parseInt(br.readLine());
        char[][] friends = new char[N][R];
        for (int i = 0; i < N; i++) {
            friends[i] = br.readLine().toCharArray();
        }

        int score = 0;
        int max = 0;
        for (int i = 0; i < R; i++) {
            int rc = 0;
            int sc = 0;
            int pc = 0;
            for (int j = 0; j < N; j++) {
                if(friends[j][i] == 'R') rc++;
                else if(friends[j][i] == 'S') sc++;
                else pc++;
            }

            max += Math.max(Math.max(sc * 2 + rc, pc * 2 + sc), rc * 2 + pc);
            
            if(sang[i] =='R') score += (sc * 2 + rc);
            else if(sang[i] == 'S') score += (pc * 2 + sc);
            else score += (rc * 2 + pc);
        }
        System.out.println(score + "\n" + max);
    }
}
