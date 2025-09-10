import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getNext(sc.nextInt()));
    }

    private static int getNext(int N) {
        for (int i = N + 1; i <= 9999; i++) {
            int num = (i / 100) + (i % 100);
            if(num * num == i) return i;
        }
        return -1;
    }
}
