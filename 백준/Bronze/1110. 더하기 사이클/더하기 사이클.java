import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int next = N;
        do {
            next = ((next % 10) * 10) + ((next / 10) + (next % 10)) % 10;
            count++;
        } while (N != next);
        System.out.println(count);
    }
}
