import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(num==2 ||num == 3) {
                result++;
                continue;
            }

            for (int j = 2; j <= num / 2; j++) {
                if(num % j == 0) break;
                if(j == (num/2)) result++;
            }
        }
        sc.nextLine();
        System.out.println(result);
    }
}