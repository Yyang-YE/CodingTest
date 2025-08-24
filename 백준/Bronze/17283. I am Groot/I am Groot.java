import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();

        int total = 0;
        int cnt = 2;
        L = (L * R) / 100;
        while(L > 5) {
            total += cnt * L;
            L = L * R / 100;
            cnt *= 2;
        }
        System.out.println(total);
    }
}
