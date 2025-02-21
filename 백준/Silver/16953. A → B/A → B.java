import java.util.Scanner;

public class Main {
    static int count = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        calculate(A, B);
        System.out.println(count);
    }

    public static void calculate(int a, int b) {
        String bs = String.valueOf(b);
        if(b != 1 && bs.charAt(bs.length() - 1) == '1') {
            b = Integer.parseInt(bs.substring(0, bs.length()-1));
            count++;
        } else {
            if(b % 2 != 0) {
                count = -1;
                return;
            }
            b /= 2;
            count++;
        }
        if(a != b) calculate(a, b);
    }
}
