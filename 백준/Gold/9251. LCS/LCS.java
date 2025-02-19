import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] LCS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int len1 = str1.length;
        int len2 = str2.length;

        LCS = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) LCS[i][j] = 0;
                else if(str1[i-1] == str2[j-1]) LCS[i][j] = LCS[i-1][j-1] + 1;
                else LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
            }
        }
        System.out.println(LCS[len1][len2]);
    }
}
