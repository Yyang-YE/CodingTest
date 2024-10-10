import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        sc.nextLine();

        int GCD = num1 > num2 ? getGCD(num1, num2) : getGCD(num2, num1);
        int LCM = num1 * num2 / GCD;

        System.out.println(GCD);
        System.out.println(LCM);
    }

    private static int getGCD(int num1, int num2) {
        int result;
        while (num2 != 0) {
            result = num1 % num2;
            num1 = num2;
            num2 = result;
        }
        return num1;
    }
}