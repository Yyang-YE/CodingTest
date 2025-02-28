import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(xSet.contains(x)) xSet.remove(x);
            else xSet.add(x);

            if(ySet.contains(y)) ySet.remove(y);
            else ySet.add(y);
        }

        for (Integer x : xSet) {
            for (Integer y : ySet) {
                System.out.println(x + " " + y);
            }
        }
    }
}
