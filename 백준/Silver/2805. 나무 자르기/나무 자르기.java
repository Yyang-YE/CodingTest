import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Integer[] woods = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(woods, Comparator.reverseOrder());

        int height = woods[0];
        int index = 0;
        while(M > 0) {
            if(index < N - 1) { // 모든 나무 안잘라도 됨
                int woodCount = index + 1;
                int diff = woods[index] - woods[index + 1];
                int newCut = woodCount * diff;
                if(newCut < M) {
                    M -= newCut;
                    height -= diff;
                    index++;
                } else {
                    while(M > 0) {
                        M -= woodCount;
                        height--;
                    }
                }
            } else { // 모든 나무 잘라야 함
                M -= N;
                height -= 1;
            }
        }
        br.close();
        System.out.println(height);
    }
}