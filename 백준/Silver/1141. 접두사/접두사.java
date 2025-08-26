import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        Arrays.sort(words);

        int count = 1; // N번째 항상 포함
        for (int i = 0; i < N - 1; i++) {
            boolean flag = true;
            for (int j = i + 1; j < N; j++) {
                if(words[j].startsWith(words[i])) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        System.out.println(count);
    }
}
