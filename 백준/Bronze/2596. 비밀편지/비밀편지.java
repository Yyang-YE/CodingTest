import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] alphabet = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        boolean flag = false;
        for (int i = 0; i < str.length(); i += 6) {
            String now = str.substring(i, i + 6);
            for (int j = 0; j < 8; j++) { // 알파벳마다 검증
                // 동일하면 끝
                if(now.equals(alphabet[j])) {
                    sb.append((char) ('A' + j));
                    break;
                }

                // 서로 다른 개수 세기
                int diff = 0;
                for (int k = 0; k < 6; k++) {
                    if(now.charAt(k) != alphabet[j].charAt(k)) diff++;
                }

                if(diff == 1) { // 추론 가능 : 바로 끝
                    sb.append((char) ('A' + j));
                    break;
                } else if(j == 7 && diff >= 2) { // 끝까지 일치 없음 : 해독 불가
                    sb = new StringBuilder(String.valueOf((i / 6) + 1));
                    flag = true;
                }
            }
            if(flag) break;
        }
        System.out.println(sb);
    }
}
