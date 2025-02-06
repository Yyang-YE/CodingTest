import java.io.*;
import java.util.*;

public class Main {
    static int[] visited = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
        System.out.println(visited[K] - 1);
    }

    public static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1; // 미방문(0)과 구분하기 위해

        while(!queue.isEmpty()) {
            int index = queue.poll();

            if(index == K) { // 값 찾음
                break;
            }
            if(index-1 >= 0 && visited[index-1] == 0) { // -1 미방문
                visited[index-1] = visited[index] + 1;
                queue.add(index-1);
            }
            if(index+1 <= 100000 && visited[index+1] == 0) { // +1 미방문
                visited[index+1] = visited[index] + 1;
                queue.add(index+1);
            }
            if(2*index <= 100000 && visited[2*index] == 0) { // *2 미방문
                visited[2*index] = visited[index]+1;
                queue.add(2*index);
            }
        } // while
    }
}