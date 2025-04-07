import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        // 101이면 100 -> 1000으로 반환
        long max = (Long.highestOneBit(N) << 1) - 1;

        if(N == max) {
            System.out.println(1 + "\n" + max);
        } else {
            System.out.println(2 + "\n" + (N ^ max) + " " + N);
        }
    }
}
