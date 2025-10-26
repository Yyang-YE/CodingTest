import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() / 100 * 100;
        int F = sc.nextInt();

        int tmp = N / F;
        tmp *= F;
        while(tmp < N) {
            tmp += F;
        }
        tmp %= 100;
        String answer = String.valueOf(tmp);
        if(answer.length() < 2) answer = "0" + answer;
        System.out.println(answer);
    }
}
