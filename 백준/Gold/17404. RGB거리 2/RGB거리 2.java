import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Color[] rHouses = new Color[N];
        Color[] gHouses = new Color[N];
        Color[] bHouses = new Color[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(i == 0) {
                rHouses[i] = new Color(r, r, r);
                gHouses[i] = new Color(g, g, g);
                bHouses[i] = new Color(b, b, b);
                continue;
            }
            rHouses[i] = new Color(r, g, b);
            gHouses[i] = new Color(r, g, b);
            bHouses[i] = new Color(r, g, b);
        }

        // DP과정
        for (int i = 1; i < N; i++) {
            if(i == 1) {
                // 최대로 설정
                rHouses[i].red = N * 1000;
                gHouses[i].green = N * 1000;
                bHouses[i].blue = N * 1000;
            } else {
                rHouses[i].red += Math.min(rHouses[i-1].green, rHouses[i-1].blue);
                gHouses[i].green += Math.min(gHouses[i-1].red, gHouses[i-1].blue);
                bHouses[i].blue += Math.min(bHouses[i-1].red, bHouses[i-1].green);
            }

            // rHouse
            rHouses[i].green += Math.min(rHouses[i-1].red, rHouses[i-1].blue);
            rHouses[i].blue += Math.min(rHouses[i-1].red, rHouses[i-1].green);

            // gHouse
            gHouses[i].red += Math.min(gHouses[i-1].green, gHouses[i-1].blue);
            gHouses[i].blue += Math.min(gHouses[i-1].red, gHouses[i-1].green);

            // bHouse
            bHouses[i].red += Math.min(bHouses[i-1].green, bHouses[i-1].blue);
            bHouses[i].green += Math.min(bHouses[i-1].red, bHouses[i-1].blue);
        }

        // 마지막 값 구하기
        // Red일 때
        int result = Math.min(Math.min(
        Math.min(rHouses[N-1].green, rHouses[N-1].blue),
        Math.min(gHouses[N-1].red, gHouses[N-1].blue)),
        Math.min(bHouses[N-1].red, bHouses[N-1].green));
        System.out.println(result);
    }

    public static class Color {
        int red;
        int green;
        int blue;

        public Color(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }
}
