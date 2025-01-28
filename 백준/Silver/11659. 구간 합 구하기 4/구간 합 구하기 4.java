import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N+1];
        st = new StringTokenizer(br.readLine());
        numbers[0] = 0;
        for (int i = 1; i <= N; i++) {
            int temp =  Integer.parseInt(st.nextToken());
            numbers[i] = numbers[i-1] + temp;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(numbers[end] - numbers[start-1]));
            if(i < M - 1) bw.write("\n");
        }
        br.close();
        bw.close();
    }
}