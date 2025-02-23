import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        boolean flag = true;
        while(!str.isEmpty()) {
            if(str.startsWith("pi")) {
                str = str.substring(2);
            } else if(str.startsWith("ka")) {
                str = str.substring(2);
            } else if(str.startsWith("chu")) {
                str = str.substring(3);
            } else {
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
