import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        // 1~N까지의 수를 넣기
        // 요구되는 배열 확인
        int[] numbers = new int[N];
        int[] needArr = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
            needArr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int numIndex = 0;
        int arrIndex = 0;

        while (arrIndex < needArr.length) {
            if (numIndex < N && numbers[numIndex] < needArr[arrIndex]) {
                stack.push(numbers[numIndex]);
                sb.append("+").append("\n");
                numIndex++;
            } else if (numIndex < N && numbers[numIndex] == needArr[arrIndex]) {
                stack.push(numbers[numIndex]);
                sb.append("+").append("\n");
                numIndex++;

                stack.pop();
                sb.append("-").append("\n");
                arrIndex++;
            } else if (!stack.isEmpty() && needArr[arrIndex] == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
                arrIndex++;
            } else {
                sb.setLength(0);
                sb.append("NO").append("\n");
                break;
            }
        }

        // 마지막 줄 바꿈 제거
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        System.out.println(sb);
    }
}