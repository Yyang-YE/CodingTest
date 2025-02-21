import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Space[] spaces = new Space[N];
        long[] answer = new long[N];

        String[] ink = br.readLine().split(" ");
        String[] vis = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            spaces[i] = new Space(i, Long.parseLong(ink[i]), Long.parseLong(vis[i]));
        }

        // answer[N-1] 은 선언시 자동으로 0이 됨
        for (int i = 0; i < N-1; i++) {
            int start = i + 1;
            int end = N - 1; // index니까

            while(start <= end) {
                int mid = (start + end) / 2;
                if(spaces[i].ink < spaces[mid].viscosity) {
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            }
            answer[i] = end - i;
        }

        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }

        br.close();
        bw.close();
    }

    public static class Space {
        int idx;
        long ink;
        long viscosity;

        public Space (int idx, long ink, long viscosity) {
            this.idx = idx;
            this.ink = ink;
            this.viscosity = viscosity;
        }
    }
}
