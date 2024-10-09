import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();

            int currentScore = 0;
            int totalScore = 0;
            for (char c : str.toCharArray()) {
                if (c == 'O') totalScore += ++currentScore;
                if (c == 'X') currentScore = 0;
            }

            if (i == N-1) {
                sb.append(totalScore);
            } else {
                sb.append(totalScore).append("\n");
            }
        }
        System.out.println(sb);
    }
}