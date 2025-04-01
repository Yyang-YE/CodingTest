import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int checksum = 1;
        int count = 0;
        for (int i = 0; i < 7; i++) {
            // 둘 다 1이면 1이라서
            if((checksum & X) == checksum) count++;
            checksum <<= 1;
        }
        System.out.println(count);
    }
}