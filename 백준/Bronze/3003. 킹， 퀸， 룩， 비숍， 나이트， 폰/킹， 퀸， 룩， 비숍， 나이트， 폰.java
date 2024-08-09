import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] have = new int[6];
        int[] must = {1, 1, 2, 2, 2, 8};

        for (int i = 0; i < 6; i++) {
            have[i] = sc.nextInt();
        }

        for (int i = 0; i < 6; i++) {
            int n = must[i] - have[i];
            if(i==5) {
                System.out.print(n);
            } else {
                System.out.print(n + " ");
            }
        }
    }
}