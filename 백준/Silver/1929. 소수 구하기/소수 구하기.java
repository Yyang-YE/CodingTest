import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = M; i <= N; i++) {
            if(isPrime(i)) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    public static boolean isPrime(int num) {
        if(num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}