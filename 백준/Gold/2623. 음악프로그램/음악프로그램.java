import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] edgeCount = new int[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for (int j = 1; j < count; j++) {
                int after = Integer.parseInt(st.nextToken());
                graph.get(before).add(after);
                edgeCount[after]++;
                before = after;
            }
        }

        // 0인 애들 넣기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(edgeCount[i] == 0) {
                queue.offer(i);
            }
        }

        int pollCount = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append("\n");
            pollCount++;

            for (int i : graph.get(node)) {
                edgeCount[i]--;
                if(edgeCount[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        if(pollCount == N) System.out.println(sb);
        else System.out.println(0);
    }
}
