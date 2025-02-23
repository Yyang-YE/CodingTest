import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] tri = new int[3];
        while(true) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                tri[i] = Integer.parseInt(st.nextToken());
            }
            if(tri[0] == 0 && tri[1] == 0 && tri[2] == 0) break;

            Arrays.sort(tri);
            if(tri[2] >= tri[0] + tri[1]) sb.append("Invalid\n");
            else if(tri[0] == tri[1] && tri[1] == tri[2]) sb.append("Equilateral\n");
            else if(tri[0] == tri[1] || tri[1] == tri[2]) sb.append("Isosceles\n");
            else sb.append("Scalene\n");
        }
        System.out.print(sb);
    }
}
