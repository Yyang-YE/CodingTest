import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> countCard = new HashMap<>();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int card = sc.nextInt();
            if(countCard.containsKey(card)) {
                countCard.put(card, countCard.get(card)+1);
            } else {
                countCard.put(card, 1);
            }
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            if(countCard.containsKey(num)) {
                sb.append(countCard.get(num)).append(" ");
            } else {
                sb.append("0 ");
            }
        }
        sc.nextLine();
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}