import java.io.*;

public class Main {
    static int[] hats = new int[9];
    static int[] arr = new int[7];
    static boolean[] visited = new boolean[9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean foundFlag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            hats[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 9; i++) {
            if(!visited[i]) dfs(0);
        }

        br.close();
        bw.close();
    }

    public static void dfs(int depth) throws IOException {
        if(depth == 7) {
            int count = 0;
            for (int i = 0; i < 7; i++) {
                count += arr[i];
            }
            if(count == 100) {
                foundFlag = true;
                for (int i = 0; i < 7; i++) {
                    bw.write(arr[i] + "\n");
                }
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if(!foundFlag && !visited[i]) {
                visited[i] = true;
                arr[depth] = hats[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
