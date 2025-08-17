import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int offset = (num % 10 == 0) ? 100 : 10;
        System.out.println(num / offset + num % offset);
    }
}
