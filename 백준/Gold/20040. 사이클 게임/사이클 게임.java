import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] root;
    static boolean cycleFlag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        root = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }

        int answer = 0;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            if(cycleFlag) continue;

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
            if(cycleFlag) answer = i;
        }
        System.out.println(answer);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            root[b] = a;
        } else { // 같음 -> 사이클
            cycleFlag = true;
        }
    }

    public static int find(int n) {
        if(n == root[n]) return n;
        return root[n] = find(root[n]);
    }
}
