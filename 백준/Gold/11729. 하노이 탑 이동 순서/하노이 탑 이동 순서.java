import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        bw.write(String.valueOf((int)Math.pow(2, N) - 1) + "\n");
        hanoi(N, 1, 2, 3);
        bw.flush();
        bw.close();
    }

    public static void hanoi(int cnt, int from, int temp, int to) throws IOException {
        if(cnt == 0) return;
        hanoi(cnt-1, from, to, temp);
        bw.write(from + " " + to + "\n");
        hanoi(cnt-1, temp, from, to);
    }
}