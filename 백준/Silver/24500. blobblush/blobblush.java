import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long N = Long.parseLong(br.readLine());

        long max = (Long.highestOneBit(N) << 1) - 1;

        if(N == max) sb.append(1).append("\n").append(max);
        else sb.append(2).append("\n").append(N ^ max).append("\n").append(N);
        System.out.println(sb);
    }
}
