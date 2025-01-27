import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            // Map -> 종류, count
            Map<String, Integer> closet = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String temp = br.readLine().split(" ")[1];
                if(closet.containsKey(temp)) {
                    closet.put(temp, closet.get(temp) + 1);
                } else {
                    closet.put(temp, 2); // 현상태 or NULL(안입음)
                }
            }
            int result = 1;
            for (String type : closet.keySet()) {
                result *= closet.get(type);
            }
            bw.write(String.valueOf(result - 1)); // 전부 NULL인 경우 제외
            if(i < T-1) bw.write("\n");
        }
        br.close();
        bw.close();
    }
}