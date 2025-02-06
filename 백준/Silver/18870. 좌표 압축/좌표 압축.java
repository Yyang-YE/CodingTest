import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] xs = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            xs[i] = num;
            set.add(num);
        }

        int count = 0;
        while(!set.isEmpty()) {
            int minVal = set.first();
            set.remove(minVal);
            map.put(minVal, count);
            count++;
        }

        for (int i = 0; i < N; i++) {
            bw.append(String.valueOf(map.get(xs[i])));
            if(i != N-1) bw.append(" ");
        }

        bw.close();
        br.close();
    }
}