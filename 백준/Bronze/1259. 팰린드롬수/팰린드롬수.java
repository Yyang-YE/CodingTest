import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true) {
            String num = sc.nextLine();
            if(num.equals("0")) break;

            for (int i = 0; i <= num.length()/2; i++) {
                if (num.charAt(i) != num.charAt(num.length()-1-i)) {
                    sb.append("no").append("\n");
                    break;
                }
                if (i == num.length()/2) {
                    sb.append("yes").append("\n");
                }
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}