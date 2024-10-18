import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        while (list.size() != 1) {
            list = playGame(list);
        }

        System.out.println(list.get(0));
    }

    public static List<Integer> playGame(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        //짝수번째만 거르기
        for (int i = 0; i < list.size()-1; i+=2) {
            result.add(list.get(i+1));
        }

        //홀수면 index=0인 값을 맨 뒤로
        if(list.size() % 2 != 0 && result.size() != 1) {
            int temp = result.get(0);
            result.remove(0);
            result.add(temp);
        }
        return result;
    }
}