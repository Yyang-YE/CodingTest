import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ps = 0;
        int pl = N-1;
        
        int min = Integer.MAX_VALUE;
        String res = "";
        
        while(ps < pl) {
            int temp = arr[ps] + arr[pl];
            if(min > Math.abs(temp)) {
                res = arr[ps] + " " + arr[pl];
                min = Math.abs(temp);
            }

            // 포인터 위치 조정
            if(temp == 0) break;
            else if(temp > 0) pl--;
            else ps++;
        }
        System.out.println(res);
    }
}
