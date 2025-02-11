import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list;
    static boolean[] visited;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            int secondNum = Integer.parseInt(br.readLine());
            num[i] = secondNum;
        }

        list = new ArrayList<>();
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        bw.write(list.size() + "\n");
        for (Integer i : list) {
            bw.write(i + "\n");
        }

        br.close();
        bw.close();
    }

    public static void dfs(int start, int target) {
        int next = num[start];
        if(!visited[next]) {
            visited[next] = true;
            dfs(next, target);
            visited[next] = false;
        }
        if(next == target) list.add(target);
    }
}
