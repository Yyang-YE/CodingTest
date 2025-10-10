import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int a = 1;
        int num = 1;
        while(num < X) {
            num += ++a;
        }

        int b;
        int diff = num - X;

        if(a % 2 == 0) {
            b = a - diff;
            a = 1 + diff;
        } else {
            a -= diff;
            b = 1 + diff;
        }
        System.out.println(b + "/" + a);
    }
}
