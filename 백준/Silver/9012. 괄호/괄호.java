import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String parenthesisString = sc.nextLine();
            results.add(checkParenthesis(parenthesisString));
        }

        // 결과 출력
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String checkParenthesis(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                count++;
            } else {
                if(count == 0) return "NO";
                else count--;
            }
        }
        return count == 0 ? "YES" : "NO";
    }
}