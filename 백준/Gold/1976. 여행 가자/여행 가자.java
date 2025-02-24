import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N= Integer.parseInt(br.readLine());
        M= Integer.parseInt(br.readLine());

        root = new int[N+1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if(connected == 1) {
                    union(i, j);
                }
            }
        }

        boolean availability = true;
        st = new StringTokenizer(br.readLine());

        if(M > 0) {
            int beforeRoot = find(Integer.parseInt(st.nextToken()));
            for (int i = 1; i < M; i++) {
                int nextRoot = find(Integer.parseInt(st.nextToken()));
                if (beforeRoot != nextRoot) {
                    availability = false;
                    break;
                }
                beforeRoot = nextRoot;
            }
        }

        // 결과 출력
        if(availability) System.out.println("YES");
        else System.out.println("NO");
    }
    
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) root[b] = a;
    }
    
    private static int find(int n) {
        if(n == root[n]) return n;
        return root[n] = find(root[n]);        
    }
}
