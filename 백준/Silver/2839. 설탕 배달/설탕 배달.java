import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int countFive = N / 5;
        while (true) {
            if((N - 5 * countFive) % 3 != 0) {
                if (countFive == 0) {
                    System.out.println(-1);
                    break;
                }
                countFive--;
            } else {
                int countThree = (N - countFive * 5) / 3;
                System.out.println(countFive + countThree);
                break;
            }
        }
    }
}