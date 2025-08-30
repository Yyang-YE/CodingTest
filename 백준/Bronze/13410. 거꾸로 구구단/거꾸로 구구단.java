import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int max = 0;
        for (int i = 1; i <= K; i++) {
            int num = N * i;
            int reverse = 0;
            while(num > 0) {
                reverse = (reverse * 10) + num % 10;
                num = num / 10;
            }
            max = Math.max(max, reverse);
        }
        System.out.println(max);
    }
}
