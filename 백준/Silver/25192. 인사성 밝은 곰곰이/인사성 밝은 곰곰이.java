import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            if(cmd.equals("ENTER")) {
                set.clear();
            } else if(!set.contains(cmd)) {
                count++;
                set.add(cmd);
            }
        }
        System.out.println(count);
    }
}
