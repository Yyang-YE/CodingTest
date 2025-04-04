import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        int len1 = arr1.length;
        int len2 = arr2.length;

        // lcs 최대 길이
        StringBuilder sb = new StringBuilder();
        int[][] lcs = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) lcs[i][j] = 0;
                else if(arr1[i-1] == arr2[j-1]) lcs[i][j] = lcs[i-1][j-1] + 1;
                else lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }

        // 문자열 구하기
        while(0 < lcs[len1][len2]) {
            if(lcs[len1][len2] == lcs[len1][len2-1]) {
                len2--; // 같은 수가 있으면 그 쪽으로 이동
            } else if(lcs[len1][len2] == lcs[len1-1][len2]) {
                len1--; // 마찬가지
            } else { // 위, 왼 모두 다르면 같은 수: 이동
                sb.append(arr1[--len1]); // 현재 글자 입력
                len2--;
            }
        }
        System.out.println(lcs[arr1.length][arr2.length] + "\n" + sb.reverse());
    }
}
