import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int timeCnt = Integer.MAX_VALUE;
    static int caseCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            System.out.println((N - K) + "\n" + 1);
        } else {
            bfs();
            System.out.println(timeCnt + "\n" + caseCnt);
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        int[] minTime = new int[100001]; // 좌표별 최단 시간
        minTime[N] = 1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(timeCnt < minTime[cur]) continue; // 더 느리면 고려할 필요X

            int[] ns = new int[] {cur - 1, cur + 1, cur * 2};
            for (int next : ns) {
                if(next == K) { // 도달 성공
                    timeCnt = minTime[cur];
                    caseCnt++;
                }

                if(next < 0 || next > 100000) continue;

                if(minTime[next] == 0 || minTime[next] == minTime[cur] + 1) {
                    minTime[next] = minTime[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
