import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static final int INF = 987654321;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 인구수 입력
        int[] population = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        // 그래프 생성
        for (int cur = 1; cur <= N; cur++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int adj = Integer.parseInt(st.nextToken());
                graph.get(cur).add(adj);
                graph.get(adj).add(cur);
            }
        }

        // 조합 구하기
        int minDiff = INF;
        for (int i = 1; i < (1 << N) - 1; i++) {
            List<Integer> area1 = new ArrayList<>();
            List<Integer> area2 = new ArrayList<>();

            int diff = 0; // 0 이면 +, 1 이면 -
            for (int j = 0; j < N; j++) {
                int area = j + 1;
                if((i & (1 << j)) == 0) {
                    area1.add(area);
                    diff += population[area];
                } else {
                    area2.add(area);
                    diff -= population[area];
                }
            }

            if(isConnected(area1) && isConnected(area2)) {
                minDiff = Math.min(minDiff, Math.abs(diff));
            }
        }
        System.out.println(minDiff == INF ? -1 : minDiff);
    }

    private static boolean isConnected(List<Integer> areaList) {
        if(areaList.isEmpty()) return false;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(areaList.get(0));
        visited.add(areaList.get(0));

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                if(!visited.contains(next) && areaList.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return areaList.size() == visited.size();
    }
}
