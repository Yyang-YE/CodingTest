import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] walls = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            walls[i] = Integer.parseInt(st.nextToken());
            H = Math.max(H, walls[i]);
        }

        int total = 0;
        for (int i = 1; i <= H; i++) {
            boolean isWater = false;
            int count = 0;
            for (int j = 0; j < W; j++) {
                if(walls[j] >= i) {
                    isWater = true;
                    if(count != 0) {
                        total += count;
                        count = 0;
                    }
                } else if(isWater){
                    count++;
                }
            }
        }
        System.out.println(total);
    }
}
