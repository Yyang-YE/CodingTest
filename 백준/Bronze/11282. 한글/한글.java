import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println((char) ('가' + sc.nextInt() - 1));
    }
}
