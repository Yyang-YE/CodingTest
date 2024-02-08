import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] string = new String[T];

        for (int i=0; i<T; i++) {
            String temp = sc.next();
            string[i] = Character.toString(temp.charAt(0)) + Character.toString(temp.charAt(temp.length() - 1));
        }
        for(int i=0; i<T; i++) {
            System.out.println(string[i]);
        }
    }
}