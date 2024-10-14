import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[] cards = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int max = 0;
        for (int i = N-1; i >= 2; i--) {
            for (int j = i-1; j >= 1; j--) {
                for (int k = j-1; k >= 0; k--) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum <= M && sum > max) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}