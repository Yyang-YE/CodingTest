import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] isbn = br.readLine().split("");

        int total = 0;
        int weight = 1;
        for (int i = 0; i < 13; i++) {
            if (isbn[i].equals("*")) {
                weight = (i % 2 == 0) ? 1 : 3;
                continue;
            }
            total += Integer.parseInt(isbn[i]) * ((i % 2 == 0) ? 1 : 3);
            total %= 10;
        }

        for (int i = 0; i < 10; i++) {
            if ((total + (i * weight)) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
