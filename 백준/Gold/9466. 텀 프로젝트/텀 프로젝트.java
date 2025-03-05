import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] graph;
    static boolean[] visited, done;
    static int count; // Team인 사람 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            count = 0; // 팀인 애들 수

            graph = new int[N+1];
            visited = new boolean[N+1];
            done = new boolean[N+1]; // 검사 완료 여부
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i] = num;
                if(num == i) {
                    done[i] = true;
                    count++;
                }
            }

            for (int i = 1; i <= N; i++) {
                if(!done[i]) {
                    checkCycle(i);
                }
            }

            bw.write((N - count) + "\n");
        }
        br.close();
        bw.close();
    }

    public static void checkCycle(int n) {
        // 이미 검사완 : 끝
        if(done[n]) return;

        // 이미 방문 : 사이클의 구성원임
        if(visited[n]) {
            done[n] = true;
            count++;
        }

        visited[n] = true;
        checkCycle(graph[n]);
        done[n] = true;
        visited[n] = false; // 재설정
    }
}
