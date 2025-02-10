import java.io.*;
import java.util.*;

public class Main {
    static int[][] triangle;
    static int[][] max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        max = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
                if(i == n-1) max[i][j] = triangle[i][j];
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(i == 0) {
                    break;
                }
                max[i-1][j] = Math.max(max[i][j], max[i][j+1]) + triangle[i-1][j];
            }
        }
        System.out.println(max[0][0]);
    }
}
