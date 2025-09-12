import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int hlo = Integer.parseInt(st.nextToken());
        int hhi = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int slo = Integer.parseInt(st.nextToken());
        int shi = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int vlo = Integer.parseInt(st.nextToken());
        int vhi = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Math.min(R, Math.min(G, B));
        int M = Math.max(R, Math.max(G, B));
        double S = 255.0 * (M - m) / M;

        double H = M == R ? 60.0 * (G - B) / (M - m) : M == G ? 120 + 60.0 * (B - R) / (M - m) : 240 + 60.0 * (R - G) / (M - m);
        if (H < 0) H += 360;

        boolean flag = (hlo <= H && H <= hhi && slo <= S && S <= shi && vlo <= M && M <= vhi);
        System.out.println(flag ? "Lumi will like it." : "Lumi will not like it.");
    }
}
