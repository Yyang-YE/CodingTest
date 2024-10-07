import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();
        sc.nextLine();

        int N = 1;
        while(N <= S) {
            S -= N;
            if (N >= S) {
                break;
            }
            N++;
        }
        System.out.println(N);
    }
}