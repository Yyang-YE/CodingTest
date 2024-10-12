import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        System.out.println(getConstructor(N));
    }

    private static int getConstructor(int N) {
        for (int i = 0; i <= N; i++) {
            int need = i;
            int temp = i;

            while (temp > 0) {
                need += temp % 10;
                temp /= 10;
            }

            if(need == N) return i;
        }
        return 0;
    }
}