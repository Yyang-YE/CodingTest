import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N+1];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 1; i <= N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());

            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }

        int[] parent = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tempQ = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;

        while(!queue.isEmpty()) {
            int node= queue.poll();
            for (int i : graph.get(node)) {
                if(!isVisited[i]) {
                    isVisited[i] = true;
                    tempQ.add(i);
                    parent[i] = node;
                }
            }
            
            if(queue.isEmpty()) {
                queue.addAll(tempQ);
                tempQ.clear();
            }
        }

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
