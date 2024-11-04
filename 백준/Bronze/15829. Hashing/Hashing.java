import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        int r = 31;
        int M = 1234567891;

        long result = 0L;

        for (int i = 0; i < L; i++) {
            result += (long) ((str.charAt(i)-96) * (Math.pow(r, i) % M)) % M;
        }
        System.out.println(result % M);
    }
}