import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] root;
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<>();

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

        long answer = 1;
        for (Integer cnt : map.values()) {
            answer = (answer * cnt) % 1000000007;
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        // 각각을 루트 노드 값으로 update
        a = find(a);
        b = find(b);

        if(a != b) {
            root[b] = a;

            if(!map.containsKey(a)) map.put(a, 1);
            if(!map.containsKey(b)) map.put(b, 1);

            map.replace(a, map.get(a) + map.get(b));
            map.remove(b);
        }
    }

    private static int find(int node) {
        if(root[node] == node) { // 자신이 루트면
            return node;
        } else {
            root[node] = find(root[node]); // 재탐색 시 시간 단축
            return root[node];
        }
    }
}
