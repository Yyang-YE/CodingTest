import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        int countTwo = 0;
        int countFive = 0;
        for (int i = 2; i <= N; i++) {
            int num = i;
            while(num % 2 == 0) {
                num /= 2;
                countTwo++;
            }
            while(num % 5 == 0) {
                num /= 5;
                countFive++;
            }
        }
        System.out.println(Math.min(countTwo, countFive));
    }
}