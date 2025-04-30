import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int maskLen = 32;
        int[] addr = new int[4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            boolean isSame = true;
            
            // 초기 설정
            if(i == 0) {
                for (int j = 0; j < 4; j++) {
                    addr[j] = Integer.parseInt(st.nextToken());
                }
                continue;
            }

            // 이후 동일 길이 비교
            for (int idx = 0; idx < 32; idx += 8) {
                int curAdd = Integer.parseInt(st.nextToken());

                if(!isSame || addr[idx/8] == curAdd) {
                    if(!isSame) addr[idx/8] = 0;
                    continue;
                }

                // 다른 부분 존재 시 로직 수행
                int bitIdx;
                for (bitIdx = 0; bitIdx < maskLen - idx; bitIdx++) {
                    if((curAdd & (128 >> bitIdx)) != (addr[idx/8] & (128 >> bitIdx))) {
                        // 다른 위치에서 업데이트 (N번쨰가 다르면 N개가 동일)
                        maskLen = idx + bitIdx;
                        // 다른 부분부터 아래를 0으로 설정
                        int mask = ((1 << bitIdx) - 1) << (8 - bitIdx);
                        addr[idx/8] = curAdd & mask;
                        break;
                    }
                }
                isSame = false;
            }
        }

        // 네트워크 정보
        for (int i = 0; i < 4; i++) {
            sb.append(addr[i]);
            if(i != 3) sb.append(".");
            else sb.append("\n");
        }

        // mask 정보 (전부 1로 바꾸기)
        for (int i = 0; i < 4; i++) {
            if(maskLen >= 8) {
                sb.append(255);
                maskLen -= 8;
            } else {
                int num = 128;
                int res = 0;
                while(maskLen-- > 0) {
                    res += num;
                    num /= 2;
                }
                sb.append(res);
            }
            if(i != 3) sb.append(".");
        }
        System.out.println(sb);
    }
}
