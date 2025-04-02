import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int K = sc.nextInt();

        int choco = 1;
        int count = 0;

        while(choco < K) choco <<= 1;
        sb.append(choco).append(" ");

        while(K > 0) {
            if(K >= choco) {
                K -= choco;
            } else {
                choco /= 2;
                count++;
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
}
