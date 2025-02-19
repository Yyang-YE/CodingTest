import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent, depth; // 각 노드의 부모/깊이
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        depth = new int[N+1];

        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // Tree 구하기
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        // 노드의 depth, parent 정보 업데이트
        setTreeInfo(1, 1, 0);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lca = getLCA(a, b);
            bw.write(lca + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void setTreeInfo(int curNode, int dep, int par) {
        depth[curNode] = dep;
        parent[curNode] = par;

        for (int i : tree[curNode]) {
            if(i == par) continue;
            setTreeInfo(i, dep+1, curNode);
        }
    }

    public static int getLCA(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // depth 맞추기
        int diff = depth[a] - depth[b];
        for (int i = 0; i < diff; i++) {
            a = parent[a];
        }

        // LCA 찾기
        while(a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
