import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        Set<String> words = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            words.add(str);
        }

        List<String> result = words.stream()
            .sorted(Comparator.comparingInt(String::length) //문자열을 길이 기준으로 정렬
            .thenComparing(Comparator.naturalOrder())) //위 기준이 동일하면 알파벳순으로 정렬
            .collect(Collectors.toList());

        for (String s : result) {
            System.out.println(s);
        }
    }
}