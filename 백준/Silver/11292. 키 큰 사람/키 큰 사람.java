import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            LinkedList<String> list = new LinkedList<>();
            double max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                double height = Double.parseDouble(st.nextToken());
                if(max <= height) {
                    if(max < height) list.clear();
                    list.add(name);
                    max = height;
                }
            }
            for (String n : list) {
                bw.write(n + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
