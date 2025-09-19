import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        System.out.println((L <= X && X <= R) ? X : (X < L) ? L : R);
    }
}
