import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] lps;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); // Ex) ABCABDABCABEAB
        String P = br.readLine(); // Ex) ABCABE

        System.out.println(kmp(S, P));
    }

    public static int kmp(String str, String pattern) {
        updateLSP(pattern);
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            // 비교 중 다른 값 발견(불일치)
            while(idx > 0 && str.charAt(i) != pattern.charAt(idx)) {
                // 일치하거나, 맨 앞으로 돌아갈 때까지 idx 재설정
                idx = lps[idx - 1];
            }
            if(str.charAt(i) == pattern.charAt(idx)) {
                idx++;
            }
            if(idx == pattern.length()) {
                return 1; // "존재"하면 검사 끝
            }
        }
        return 0;

    }

    public static void updateLSP(String pattern) {
        int pl = pattern.length();
        lps = new int[pl]; // 기본이 0으로 초기화 되어 있음

        int len = 0;
        for (int i = 1; i < pl; i++) {
            // 같아서 돌다가 달라지면
            while(len > 0 && pattern.charAt(i) != pattern.charAt(len)) {
                // while이니까 같아질때까지 뒤로가기
                len = lps[len-1];
            }

            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
            }
        }
    }
}
