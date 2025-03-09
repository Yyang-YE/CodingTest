import java.io.*;

public class Main {
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        root = new int[G+1];
        for (int i = 1; i <= G; i++) {
            root[i] = i;
        }

        int answer = 0;
        boolean availability = true;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            if(!availability) continue;

            int emptyG = find(g);
            if(emptyG != 0) { // 도킹 가능
                answer++;
                union(emptyG, emptyG-1);
            } else { // 도킹 가능한 것이 없으면 0
                availability = false;
            }
        }
        System.out.println(answer);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) root[a] = b;
    }

    public static int find(int n) {
        if(n == root[n]) return n;
        else return root[n] = find(root[n]);
    }
}
