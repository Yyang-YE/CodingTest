import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        switches = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            switches[i] = !st.nextToken().equals("0");
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            if(st.nextToken().equals("1")) { // 남자인 경우
                maleSwitch(Integer.parseInt(st.nextToken()));
            } else { // 여자인 경우
                femaleSwitch(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= N; i++) {
            if(switches[i]) sb.append(1);
            else sb.append(0);

            if(i != N) sb.append(" ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void maleSwitch(int num) {
        int temp = num;
        while(temp <= N) {
            switches[temp] = !switches[temp];
            temp += num;
        }

    }

    public static void femaleSwitch(int num) {
        switches[num] = !switches[num];

        int upper = num+1;
        int lower = num-1;

        while(lower > 0 && upper <= N) {
            if(switches[lower] == switches[upper]) {
                switches[lower] = switches[upper] = !switches[lower];
            } else {
                break;
            }
            upper++;
            lower--;
        }
    }
}
