import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int s = 1;
            int ans = 1;

            int maxLen = 0;
            while(s <= N) {
                int e = Math.min(N, 3 * s - 1);
                if(e-s+1 > maxLen) {
                    maxLen = e - s + 1;
                    ans = s;
                }
                s <<= 1;
            }
            print(ans, Math.min(N, 3 * ans - 1));
        }
        br.close();;
        bw.close();
    }

    public static void print(int s, int e) throws IOException {
        bw.write((e - s + 1) + "\n");
        for (int i = s; i <= e; i++) {
            bw.write(i + " ");
        }
        bw.write("\n");
    }
}
