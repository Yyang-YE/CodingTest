import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> S = new HashSet<>();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] prompt = br.readLine().split(" ");
            switch (prompt[0]) {
                case "add":
                    S.add(Integer.parseInt(prompt[1]));
                    break;
                case "remove":
                    S.remove(Integer.parseInt(prompt[1]));
                    break;
                case "check":
                    bw.write(S.contains(Integer.parseInt(prompt[1])) ? "1" : "0");
                    if(i != M-1)bw.write("\n");
                    break;
                case "toggle":
                    int x = Integer.parseInt(prompt[1]);
                    if(S.contains(x)) S.remove(x);
                    else S.add(x);
                    break;
                case "all":
                    S = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
                    break;
                case "empty":
                    S.clear();
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}