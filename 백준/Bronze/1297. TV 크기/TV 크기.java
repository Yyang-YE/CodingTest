import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double D = Integer.parseInt(st.nextToken());
        double H = Integer.parseInt(st.nextToken());
        double W = Integer.parseInt(st.nextToken());

        double x = Math.sqrt(Math.pow(D, 2) / (Math.pow(H, 2) + Math.pow(W, 2)));
        System.out.println((int) (x * H) + " " + (int) (x * W));
    }
}