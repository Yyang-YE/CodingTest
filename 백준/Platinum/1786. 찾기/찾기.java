import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] lps;
    static int count = 0;
    static List<Integer> indexes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String T = br.readLine();
        String P = br.readLine();

        kmp(T, P);
        bw.write(count + "\n");
        for (int i : indexes) {
            bw.write(i + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    public static void kmp(String str, String pattern) {
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
                // 첫 글자는 pat.length()-1만큼 돌아가야함 + index가 1부터 시작
                indexes.add(i-pattern.length()+2);
                count++;
                // idx 재설정
                idx = lps[idx-1];
            }
        }
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
