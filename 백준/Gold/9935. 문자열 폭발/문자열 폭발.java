import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String boom = br.readLine();

        for (char c : str.toCharArray()) {
            sb.append(c);

            if(sb.length() >= boom.length()) { // 짧으면 안터짐
                boolean sameFlag = true;
                for (int i = 0; i < boom.length(); i++) {
                    if(sb.charAt(sb.length() - boom.length() + i) != boom.charAt(i)) {
                        sameFlag = false;
                        break;
                    }
                }
                if(sameFlag) {
                    sb.delete(sb.length()-boom.length(), sb.length());
                }
            }
        }
        if(sb.length() == 0) {
            sb.append("FRULA");
        }
        System.out.println(sb);
    }
}
