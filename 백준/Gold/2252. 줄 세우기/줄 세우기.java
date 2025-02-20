import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] edgeCount = new int[N+1]; // 해당노드 가리키는 간선 갯수 보관
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            edgeCount[b]++; // a가 b를 가리키므로 ++
        }

        // 그래프로 위상정렬
        Queue<Integer> queue = new LinkedList<>();

        // 시작: indegree가 0인 것들을 queue에 담기
        for (int i = 1; i <= N; i++) {
            if(edgeCount[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int std = queue.poll();

            bw.write(std + " ");

            for (int i : graph.get(std)) {
                edgeCount[i]--;
                if(edgeCount[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        br.close();
        bw.close();
    }
}
