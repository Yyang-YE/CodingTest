import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        String str = Integer.toString(A * B * C);
        for (char c : str.toCharArray()) {
            count[Character.getNumericValue(c)]++;
        }

        for (int i : count) {
            System.out.println(i);
        }
    }
}