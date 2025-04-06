import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";

        int max = 0;
        for (int i = 0; i < 7; i++) {
            String[] tmp = br.readLine().split(" ");
            if(Integer.parseInt(tmp[1]) > max) {
                answer = tmp[0];
                max = Integer.parseInt(tmp[1]);
            }
        }
        System.out.println(answer);
    }
}
