import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int maxAddr = 1;
        int count = 1;
        
        for (int i = 0; i < N; i++) {
            maxAddr +=  i * 6;
            if (N > maxAddr) count++;
            else break;
        }
        System.out.println(count);
    }
}