import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int answer;

        if(n1 % 10 > n2 % 10) {
            answer = n1;
        } else if (n1 % 10 < n2 % 10) {
            answer = n2;
        } else {
            if(n1/10%10 > n2/10%10) {
                answer = n1;
            } else if (n1/10%10 < n2/10%10) {
                answer = n2;
            } else {
                if (n1/100 > n2/100) {
                    answer = n1;
                } else {
                    answer = n2;
                }
            }
        }
        StringBuilder result = new StringBuilder(Integer.toString(answer)).reverse();
        System.out.println(result);
    }
}