import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            int currentNum = sc.nextInt();
            if(currentNum == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(currentNum);
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        System.out.println(total);
    }
}