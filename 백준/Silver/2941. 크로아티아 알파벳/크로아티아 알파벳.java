import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;
        while(str.length() > 0) {
            if(str.startsWith("dz=")){
                str = str.substring(3);
            } else if(str.startsWith("c=") || str.startsWith("c-") || str.startsWith("d-") ||
                str.startsWith("lj") || str.startsWith("nj") || str.startsWith("s=") || str.startsWith("z=")) {
                str = str.substring(2);
            } else {
                str = str.substring(1);
            }
            count++;
        }
        System.out.println(count);
    }
}
