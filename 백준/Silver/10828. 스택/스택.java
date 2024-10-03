import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String prompt = sc.nextLine();

            if(prompt.contains("push")) {
                stack.push(Integer.valueOf(prompt.split(" ")[1]));
            } else if(prompt.equals("pop")) {
                results.add(stack.isEmpty()? -1 : stack.pop());
            } else if(prompt.equals("size")) {
                results.add(stack.size());
            } else if(prompt.endsWith("empty")) {
                results.add(stack.isEmpty() ? 1 : 0);
            } else if(prompt.equals("top")) {
                results.add(stack.isEmpty()? -1 : stack.peek());
            }
        }

        for (Integer result : results) {
            System.out.println(result);
        }
    }
}