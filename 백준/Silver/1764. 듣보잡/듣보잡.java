import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Set<String> notHeard = new HashSet<>();
        List<String> duplicated = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            notHeard.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String notSeen = br.readLine();
            if(notHeard.contains(notSeen)) duplicated.add(notSeen);
        }

        Collections.sort(duplicated);
        bw.write(Integer.toString(duplicated.size()));

        for (String s : duplicated) {
            bw.write("\n");
            bw.write(s);
        }
        bw.flush();
        br.close();
        bw.close();
    }
}