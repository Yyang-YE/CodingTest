import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int min = Integer.MAX_VALUE;
    static final int max = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        countMove(N, K);
        System.out.println(min);
    }

    public static void countMove(int N, int K) {
        boolean[] visited = new boolean[100001];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, 0));
        visited[N] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.num] = true;
            if(node.num == K) min = Math.min(min, node.time);

            if(node.num * 2 <= max && !visited[node.num * 2]) queue.offer(new Node(node.num*2, node.time));
            if(node.num + 1 <= max && !visited[node.num + 1]) queue.offer(new Node(node.num+1, node.time+1));
            if(node.num - 1 >= 0 && !visited[node.num - 1]) queue.offer(new Node(node.num-1, node.time+1));
        }
    }

    public static class Node {
        int num;
        int time;
        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}
