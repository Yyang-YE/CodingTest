import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        br.readLine();
        String S = br.readLine();

        int count = 0;
        for (int i = 0; i < N; i++) {
            if(i == 0) sb.append("IOI");
            else sb.append("OI");
        }

        while(true) {
            int index = S.indexOf(sb.toString());
            if(index != -1) {
                count++;
                S = S.substring(index + 1);
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
