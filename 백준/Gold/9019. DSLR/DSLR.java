import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String minCmd;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            check(A, B);
            bw.write(minCmd + "\n");
        }
        br.close();
        bw.close();
    }

    public static void check(int A, int B) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(A, ""));

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            // 결과 업데이트
            if (info.num == B) {
                minCmd = info.cmd;
                return;
            }
            if(visited[info.num]) continue;
            else visited[info.num] = true;

            queue.add(new Info(D(info.num), info.cmd + "D"));
            queue.add(new Info(S(info.num), info.cmd + "S"));
            queue.add(new Info(L(info.num), info.cmd + "L"));
            queue.add(new Info(R(info.num), info.cmd + "R"));
        }
    }

    public static int D(int num) {
        num = (num * 2) % 10000;
        return num;
    }

    public static int S(int num) {
        num = (num == 0) ? 9999 : num - 1;
        return num;
    }

    public static int L(int num) {
        num = (num % 1000) * 10 + (num / 1000);
        return num;
    }

    public static int R(int num) {
        num = (num / 10) + (num % 10) * 1000;
        return num;
    }

    public static class Info {
        int num;
        String cmd;

        public Info(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }
}
