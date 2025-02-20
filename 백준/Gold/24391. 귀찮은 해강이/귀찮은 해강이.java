import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        root = new int[N+1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }
        
        String[] timeTable = br.readLine().split(" ");

        int move = 0;
        for (int i = 0; i < timeTable.length-1; i++) {
            int bf = Integer.parseInt(timeTable[i]);
            int af = Integer.parseInt(timeTable[i+1]);
            if(find(bf) != find(af)) move++;
        }

        System.out.println(move);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            root[b] = a;
        }
    }

    private static int find (int node) {
        if(root[node] == node) return node;
        root[node] = find(root[node]);
        return root[node];
    }
}
