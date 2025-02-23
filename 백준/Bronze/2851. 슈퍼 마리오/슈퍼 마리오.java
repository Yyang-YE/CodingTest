import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            if(flag) continue;
            if(total + num < 100) {
                total += num;
            } else {
                if(100 - total >=  total + num - 100) {
                    total += num;
                }
                flag = true;
            }
        }
        System.out.println(total);
    }
}