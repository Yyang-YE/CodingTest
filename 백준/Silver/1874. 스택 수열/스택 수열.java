import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = sc.nextInt();
        int curNum = 1;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(!flag) continue;
            // 스택이 비거나 peek()가 num보다 작으 경우
            if(stack.isEmpty() || stack.peek() <= num) {
                for (int j = curNum; j <= num; j++) {
                    stack.push(curNum++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }  else { // peek()가 num보다 큰 경우
                sb.setLength(0);
                sb.append("NO");
                flag = false;
            }
        }
        System.out.println(sb);
    }
}
