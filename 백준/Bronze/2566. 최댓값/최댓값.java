import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max = -1;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(max < temp) {
                    max = temp;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max + "\n" + x + " " + y);
    }
}
