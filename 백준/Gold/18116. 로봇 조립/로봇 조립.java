import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> root = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(!root.containsKey(a)) root.put(a, -1);
                if(!root.containsKey(b)) root.put(b, -1);

                union(a, b);
            } else {
                int c = Integer.parseInt(st.nextToken());
                if(!root.containsKey(c)) bw.write(1 + "\n");
                else bw.write(root.get(find(c))*(-1) + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            // 항상 a가 b보다 작게
            if(a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            root.replace(a, root.get(a) + root.get(b));
            root.replace(b, a);
        }
    }

    public static int find(int n) {
        if(root.get(n) < 0) return n;
        root.replace(n, find(root.get(n)));
        return root.get(n);
    }
}
