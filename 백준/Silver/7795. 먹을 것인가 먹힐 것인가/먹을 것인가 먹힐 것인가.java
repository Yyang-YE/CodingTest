import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] arrA = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);

            int[] arrB = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrB);

            int bp = 0;
            int count = 0;

            for (int ap = 0; ap < N; ap++) {
                for (int i = bp; i <M ; i++) {
                    if(arrA[ap] <= arrB[bp]) { // ap가
                        count += bp;
                        break;
                    } else bp++;
                }
                if(bp == M) {
                    count += M;
                }
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.close();
    }
}
