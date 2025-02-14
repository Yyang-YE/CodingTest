import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] isConnected;
    static boolean[] isVisited;
    static int[] bacon;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bacon = new int[N+1];
        isConnected = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            isConnected[A][B] = isConnected[B][A] = true;
        }

        int answer = 1;
        for (int i = 1; i <= N; i++) {
            BFS(i);
            if(bacon[answer] > bacon[i]) {
                answer = i;
            }
        }
        System.out.println(answer);
    }

    public static void BFS(int person) {
        int unvisitedCount = N-1;
        isVisited = new boolean[N+1];
        isVisited[person] = true;
        bacon[person] += unvisitedCount; // 모두 동일 - 계산 불필요..?

        Queue<Integer> queue = new LinkedList<>();
        queue.add(person);

        Queue<Integer> tempQ = new LinkedList<>();
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= N; i++) {
                // 열결 & 미방문
                if(isConnected[cur][i] && !isVisited[i]) {
                    isVisited[i] = true;
                    unvisitedCount--;
                    tempQ.add(i);
                }
            }

            if(queue.isEmpty()) {
                bacon[person] += unvisitedCount;
                queue.addAll(tempQ);
                tempQ.clear();
            }
        }
    }
}
