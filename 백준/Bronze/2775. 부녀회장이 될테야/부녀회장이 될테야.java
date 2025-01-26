import java.io.*;

public class Main {
    static int[][] apartment;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            apartment = new int[k+1][n+1];

            for (int j = 0; j <= k; j++) {
                for (int l = 1; l <= n; l++) {
                    if(j == 0) {
                        apartment[j][l] = l;
                    } else if(l == 1) {
                        apartment[j][l] = 1;
                    } else {
                        apartment[j][l] = apartment[j-1][l] + apartment[j][l-1];
                    }
                }
            }
            bw.write(String.valueOf(apartment[k][n]));
            if(i < T-1) bw.write("\n");
        }
        br.close();
        bw.close();
    }
}