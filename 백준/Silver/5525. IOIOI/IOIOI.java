import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;
        for (int i = 0; i < M; i++) {
            if(S.charAt(i) == 'I') {
                int temp = i; // 문자열 인덱스 탐색용
                int countN = 0;

                while (temp + 2 < M) {
                    if (S.charAt(temp+1) == 'O' && S.charAt(temp+2) == 'I') {
                        countN++;
                        temp += 2;
                        if(countN == N) {
                            countN--;
                            count++;
                        }
                    } else {
                        break;
                    }
                }
                i = temp;
            }
        }
        System.out.println(count);
    }
}
