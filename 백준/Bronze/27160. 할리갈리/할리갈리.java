import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] card = br.readLine().split(" ");
            int num = Integer.parseInt(card[1]);
            if(map.containsKey(card[0])) num += map.get(card[0]);
            map.put(card[0], num);
        }

        boolean flag = false;
        for (int v : map.values()) {
            if (v == 5) {
                flag = true;
                break;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
}
