import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strings = sc.next();
        int n = sc.nextInt();

        System.out.println(strings.charAt(n-1));
    }
}