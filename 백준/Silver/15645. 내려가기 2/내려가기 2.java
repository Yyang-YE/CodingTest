import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] max = new int[3];
        int[] min = new int[3];
        max[0] = min[0] = Integer.parseInt(st.nextToken());
        max[1] = min[1] = Integer.parseInt(st.nextToken());
        max[2] = min[2] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());

            // 최대
            int[] tmp = max.clone();
            max[0] = Math.max(tmp[0], tmp[1]) + n1;
            max[1] = Math.max(tmp[0], Math.max(tmp[1], tmp[2])) + n2;
            max[2] = Math.max(tmp[1], tmp[2]) + n3;

            // 최소
            tmp = min.clone();
            min[0] = Math.min(tmp[0], tmp[1]) + n1;
            min[1] = Math.min(tmp[0], Math.min(tmp[1], tmp[2])) + n2;
            min[2] = Math.min(tmp[1], tmp[2]) + n3;
        }

        System.out.println(Math.max(max[0], Math.max(max[1], max[2])) + " "
        + Math.min(min[0], Math.min(min[1], min[2])));
    }
}
