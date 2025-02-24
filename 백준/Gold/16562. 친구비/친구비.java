import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] root;
    static int[] friendMoney;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        root = new int[N+1];
        friendMoney = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            root[i] = i;
            friendMoney[i] = Integer.parseInt(st.nextToken());
            map.put(i, friendMoney[i]); // 루트별 최소 친구비
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int total = 0;
        for (int moneys : map.values()) {
            total += moneys;
        }

        if(total > k) System.out.println("Oh no");
        else System.out.println(total);
    }

    public static void union(int a, int b) {
        int newA = find(a);
        int newB = find(b);
        if(newA != newB) {
            root[newB] = newA;
            map.replace(newA, Math.min(Math.min(map.get(newA), friendMoney[a]), Math.min(map.get(newB), friendMoney[b])));
            map.remove(newB);
        }
    }

    public static int find(int n) {
        if(root[n] == n) return n;
        else return root[n] = find(root[n]);
    }
}
