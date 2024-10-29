import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        int temp = 0;
        sb.append("<");
        while (true) {
            temp = (temp + K - 1) % people.size();
            sb.append(people.get(temp));
            people.remove(temp);

            if(people.isEmpty()) {
                sb.append(">");
                break;
            } else {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}