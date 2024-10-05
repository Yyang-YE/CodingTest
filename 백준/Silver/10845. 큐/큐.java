import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        sc.nextLine();

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String prompt = sc.nextLine();
            switch (prompt.split(" ")[0]) {
                case "push":
                    queue.offer(Integer.valueOf(prompt.split(" ")[1]));
                    break;
                case "pop":
                    sb.append(queue.peek() != null ? queue.poll() : -1).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}