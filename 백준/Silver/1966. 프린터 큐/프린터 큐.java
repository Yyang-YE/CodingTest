import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            Queue<int[]> printer = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                printer.add(new int[]{j, num});
            }

            int count = 0;
            while(!printer.isEmpty()) {
                int[] head = printer.poll();

                boolean canPrint = printer.stream()
                    .anyMatch(arr -> arr[1] > head[1]);

                if(!canPrint) {
                    count++;
                    if (head[0] == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                } else {
                    printer.add(head);
                }
            }
        }
        sc.nextLine();
        System.out.println(sb.deleteCharAt(sb.length()-1));
    }
}