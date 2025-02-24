import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String[] nums = sc.nextLine().split(",");
            sb.append(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1])).append("\n");
        }
        System.out.print(sb);
    }
}