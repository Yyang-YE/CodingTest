import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int[] alphabet = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};

        String s = sc.nextLine();
        for (char c : s.toCharArray()) {
            result += alphabet[(int) c - 'A'];
        }
        System.out.println(result);
    }
}