import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        int dirtRoot = 0;
        if(truth > 0 ) dirtRoot = Integer.parseInt(st.nextToken());
        for (int i = 1; i < truth; i++) {
            int secondP = Integer.parseInt(st.nextToken());
            union(dirtRoot, secondP);
        }

        List<Integer> partyPPL = new ArrayList<>();
        // 파티 정보 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pplCount = Integer.parseInt(st.nextToken());

            // 그래프 연결
            int firstP = Integer.parseInt(st.nextToken());
            for (int j = 1; j < pplCount; j++) {
                int secondP = Integer.parseInt(st.nextToken());
                union(firstP, secondP);
                firstP = secondP;
            }
            // 같은 파티 참석자는 같은 루트를 가짐 -> 파티 인원 중 한명을 검사용으로 보관
            partyPPL.add(firstP);
        }

        int count = 0;
        dirtRoot = find(dirtRoot);
        for (int ppl : partyPPL) {
            if(find(ppl) != dirtRoot) count++;
        }
        System.out.println(count);
    }

    public static void union(int a, int b) {
        a = root[find(a)];
        b = root[find(b)];
        if(a != b) root[b] = a;
    }

    public static int find(int n) {
        if(root[n] == n) return n;
        return root[n] = find(root[n]);
    }
}
