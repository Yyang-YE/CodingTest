import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Computer[] network = new Computer[N+1];
        for (int i = 1; i <= N; i++) {
            network[i] = new Computer(i);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            network[num1].connected.add(num2);
            network[num2].connected.add(num1);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        network[1].isVisited = true;

        int count = 0;
        while(!stack.isEmpty()) {
            int nodeIndex = stack.pop();
            for (Integer i : network[nodeIndex].connected ) {
                if(!network[i].isVisited) {
                    stack.push(i);
                    network[i].isVisited = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static class Computer {
        int id;
        boolean isVisited = false;
        List<Integer> connected = new ArrayList<>();

        public Computer(int id) {
            this.id = id;
        }
    }
}