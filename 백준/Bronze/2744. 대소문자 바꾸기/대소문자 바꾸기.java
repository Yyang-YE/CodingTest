import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = sc.nextLine();

        for (char c : str.toCharArray()) {
            if(c >= 'a' && c <= 'z') sb.append(Character.toUpperCase(c));
            else sb.append(Character.toLowerCase(c));
        }

        System.out.println(sb);
    }
}