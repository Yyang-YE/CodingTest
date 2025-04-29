import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Boolean> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            
            if(st.nextToken().equals("enter")) map.put(name, true);
            else map.put(name, false);
        }

        for (String s : map.keySet()) {
            if(map.get(s)) sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
