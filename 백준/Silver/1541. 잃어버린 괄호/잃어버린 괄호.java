import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        List<Integer> tempResult = new ArrayList<>();

        // -로 끊기, 다음 -가 나올때까지 모든 수를 다 더하기
        for (String s : expr.split("-")) {
            int totalNum = 0;
            for (String str : s.split("\\+")) {
                totalNum += Integer.parseInt(str);
            }
            tempResult.add(totalNum);
        }

        int result = tempResult.get(0);
        for (int i = 1; i < tempResult.size(); i++) {
            result -= tempResult.get(i);
        }
        System.out.println(result);
    }
}
