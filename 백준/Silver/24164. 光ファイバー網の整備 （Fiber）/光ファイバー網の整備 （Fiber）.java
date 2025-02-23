import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int totalRoot;
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        root = new int[N+1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        totalRoot = N;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }
        System.out.println(totalRoot - 1);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            root[b] = a;
            totalRoot--;
        }
    }

    private static int find(int n) {
        if(n == root[n]) return n;
        return root[n] = find(root[n]);
    }
}
