import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int cnt = 0;
        boolean isFirst = true;
        for (int i = 0; i < N; i++) {
            double d = Double.parseDouble(st.nextToken());
            if(d <= 0) continue;
            if(isFirst) {
                cnt += (int) Math.ceil(d);
                isFirst = false;
            } else {
                cnt += (int) Math.floor(d);
            }
        }
        System.out.println(cnt);
    }
}
