import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static LinkedList<Integer>[] sawTooth;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 톱니 그래프 형성
        T = Integer.parseInt(br.readLine());
        sawTooth = new LinkedList[T];
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            sawTooth[i] = new LinkedList<>();
            for (int j = 0; j < 8; j++) { // 톱니 8개
                sawTooth[i].add(str.charAt(j) - '0');
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int sawNum = Integer.parseInt(st.nextToken());
            int cmd = Integer.parseInt(st.nextToken());

            visited = new boolean[T];
            turnSaw(sawNum, cmd);
        }

        // 정답 입력
        int answer = 0;
        for (int i = 0; i < T; i++) {
            answer += sawTooth[i].get(0);
        }
        System.out.println(answer);
        br.close();
    }

    public static void turnSaw(int saw, int cmd) {
        visited[saw-1] = true;
        boolean flagL = (saw != 1) && !visited[saw-2] && !sawTooth[saw-1].get(6).equals(sawTooth[saw-2].get(2));
        boolean flagR = (saw != T) && !visited[saw] && !sawTooth[saw-1].get(2).equals(sawTooth[saw].get(6));

        if(cmd == 1) turnRight(saw);
        else turnLeft(saw);

        if(flagL) turnSaw(saw-1, (cmd * -1));
        if(flagR) turnSaw(saw+1, (cmd * -1));
    }

    // 시계방향 돌리기
    public static void turnRight(int saw) {
        int temp = sawTooth[saw-1].get(7);
        sawTooth[saw-1].remove(7);
        sawTooth[saw-1].add(0, temp);
    }

    // 반시계방향 돌리기
    public static void turnLeft(int saw) {
        int temp = sawTooth[saw-1].get(0);
        sawTooth[saw-1].remove(0);
        sawTooth[saw-1].add(temp);
    }
}
