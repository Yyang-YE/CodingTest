import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] count = new int[10];
        boolean isSix = true;

        while(N != 0) {
            int num = N % 10;
            if(num == 9 || num == 6) {
                if(isSix) count[6]++;
                else count[9]++;
                isSix = !isSix;
            } else {
                count[num]++;
            }
            N /= 10;
        }
        Arrays.sort(count);
        System.out.println(count[9]);
    }
}
