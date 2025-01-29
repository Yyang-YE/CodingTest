import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = 0;
        for (int i = 0; i < 3; i++) {
            String temp = br.readLine();

            if(!temp.equals("Fizz") && !temp.equals("Buzz") && !temp.equals("FizzBuzz")) {
                number = Integer.parseInt(temp) + (3 - i);
            }
        }

        if(number % 3 == 0) {
            sb.append("Fizz");
        }
        if(number % 5 == 0) {
            sb.append("Buzz");
        }

        if(sb.length() == 0) {
            System.out.println(number);
        } else {
            System.out.println(sb);
        }
    }
}