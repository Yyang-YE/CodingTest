import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int code = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            if(code == 1) { // 주소
                sb.append(getNum(str)).append("\n");
            } else { // 정수
                sb.append(getIP(str)).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static String getNum(String str) {
        String[] arr = str.split("\\.");
        StringBuilder tsb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            tsb.append(String.format("%8s", Integer.toBinaryString(Integer.parseInt(arr[i]))).replace(' ', '0'));
        }
        BigInteger res = new BigInteger(tsb.toString(), 2);
        return res.toString();
    }

    public static String getIP(String str) {
        BigInteger bi = new BigInteger(str);
        String binary = String.format("%064d", new BigInteger(bi.toString(2)));

        StringBuilder tsb = new StringBuilder();
        for (int i = 0; i < 64; i += 8) {
            String tmp = binary.substring(i, i + 8);
            tsb.append(Integer.parseInt(tmp, 2));
            if(i < 56) tsb.append(".");
        }
        return tsb.toString();
    }
}
