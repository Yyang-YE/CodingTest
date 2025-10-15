import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Info> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            while(true) {
                if(stack.isEmpty()) {
                    stack.push(new Info(i, cur));
                    sb.append("0 ");
                    break;
                }

                Info p = stack.peek();

                if(p.height > cur) {
                    sb.append(p.idx).append(" ");
                    stack.push(new Info(i, cur));
                    break;
                } else { // cur이 더 크면 작은 탑은 레이저 만날 수 X
                    stack.pop();
                }
            }
        }
        System.out.println(sb);
    }

    public static class Info {
        int idx;
        int height;

        public Info(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
