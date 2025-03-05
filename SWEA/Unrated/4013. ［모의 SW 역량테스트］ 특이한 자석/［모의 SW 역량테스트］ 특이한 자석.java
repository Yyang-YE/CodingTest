import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static LinkedList<Integer>[] sawTooth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());

            // 톱니 그래프 형성
            sawTooth = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                sawTooth[i] = new LinkedList<>();
                for (int j = 0; j < 8; j++) { // 톱니 8개
                    sawTooth[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            // K번의 명령 수행
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int sawNum = Integer.parseInt(st.nextToken());
                int cmd = Integer.parseInt(st.nextToken());

                turnSaw(sawNum, cmd, true, true);
            }

            // 정답 입력
            int answer = 0;
            for (int i = 0, p = 1; i < 4; i++, p *= 2) {
                answer += sawTooth[i].get(0) * p;
            }
            bw.write("#" + tc + " " + answer + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void turnSaw(int saw, int cmd, boolean left, boolean right) {
        boolean flagOne, flagTwo, flagThree, flagFour;
        switch (saw) {
            case 1:
                // 2번 영향 여부 flag
                flagTwo = right && !sawTooth[0].get(2).equals(sawTooth[1].get(6));

                if(cmd == 1) turnRight(saw);
                else turnLeft(saw);

                if(flagTwo) turnSaw(2, (cmd * -1), false, true);
                break;
            case 2:
                // 1번 - 3번 영향 여부 flag
                flagOne = left && !sawTooth[1].get(6).equals(sawTooth[0].get(2));
                flagThree = right && !sawTooth[1].get(2).equals(sawTooth[2].get(6));

                if(cmd == 1) turnRight(saw);
                else turnLeft(saw);

                if(flagOne) turnSaw(1, (cmd * -1), false, false);
                if(flagThree) turnSaw(3, (cmd * -1), false, true);
                break;

            case 3:
                // 2번 - 4번 영향 여부 flag
                flagTwo = left && !sawTooth[2].get(6).equals(sawTooth[1].get(2));
                flagFour = right && !sawTooth[2].get(2).equals(sawTooth[3].get(6));

                if(cmd == 1) turnRight(saw);
                else turnLeft(saw);

                if(flagTwo) turnSaw(2, (cmd * -1), true, false);
                if(flagFour) turnSaw(4, (cmd * -1), false, false);
                break;

            case 4:
                // 3번 영향 여부 flag
                flagFour = left && !sawTooth[3].get(6).equals(sawTooth[2].get(2));

                if(cmd == 1) turnRight(saw);
                else turnLeft(saw);

                if(flagFour) turnSaw(3, (cmd * -1), true, false);
                break;
        }
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
