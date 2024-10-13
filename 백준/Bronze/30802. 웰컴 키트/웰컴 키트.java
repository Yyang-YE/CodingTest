import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        int[] sizes = Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int T = sc.nextInt();
        int P = sc.nextInt();
        sc.nextLine();

        int countShirt = 0;
        for (int s : sizes) {
            if (s == 0) continue;
            if(T >= s) countShirt++;
            else countShirt += (s % T == 0) ? s / T : (s / T + 1);
        }

        System.out.println(countShirt);
        System.out.println(N / P + " " + N % P);
    }
}