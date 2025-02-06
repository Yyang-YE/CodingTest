import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        while(!str.equals(".")) {
            boolean endFlag = false;
            Stack<Character> stack = new Stack<>();
            for (char c : str.toCharArray()) {
                if(c == '(' || c == '[') {
                    stack.push(c);
                } else if(c == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') break;
                    else stack.pop();
                } else if(c == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') break;
                    else stack.pop();
                } else if(c == '.') {
                    endFlag = true;
                }
            }
            if(endFlag && stack.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");

            str = br.readLine();
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}
