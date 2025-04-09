import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());

            if(a == 0 && b == 0 && c == 0) break;

            bw.write("Triangle #" + count++ + "\n");
            if (a == -1) {
                a = Math.round(Math.sqrt(c*c - b*b)*1000)/1000.0;
                if(c < b || a == 0) bw.write("Impossible.\n\n");
                else bw.write("a = " + String.format("%.3f\n\n", a));
            } else if (b == -1) {
                b = Math.round(Math.sqrt(c*c - a*a)*1000)/1000.0;
                if(c < a || b == 0) bw.write("Impossible.\n\n");
                else bw.write("b = " + String.format("%.3f\n\n", b));
            } else {
                c = Math.round(Math.sqrt(a*a + b*b)*1000)/1000.0;
                if(c == 0) bw.write("Impossible.\n\n");
                else bw.write("c = " + String.format("%.3f\n\n", c));
            }
        }
        br.close();
        bw.close();
    }
}
