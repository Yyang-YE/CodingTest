import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I")) {
                    // num으로 가져온거 +1 or 1
                    map.put(num, map.getOrDefault(num, 0) + 1);

                } else {
                    if(!map.isEmpty()) {
                        int key = 0;
                        if (num == 1) { // 최대 삭제
                            key = map.lastKey();
                        } else if (num == -1) { // 최소 삭제
                            key = map.firstKey();
                        }

                        map.put(key, map.get(key) - 1);
                        if(map.get(key) == 0) {
                            map.remove(key);
                        }
                    }
                }
            }
            
            // 정답 입력
            if(map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
