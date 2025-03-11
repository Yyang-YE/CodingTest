import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        String word = br.readLine();

        String temp = word;
        list.add(word);
        for (int i = 1; i <= X; i++) {
            // 되돌리기 로직
            temp = unBlank(temp);
            if(word.equals(temp)) {
                // count번 돌았을 때 루프 돌아옴
                X -= i * (X / i);
                break;
            }
        }
        System.out.println(list.get(X));
    }
    
    public static String unBlank(String word) {
        int len = word.length();
        StringBuilder sb = new StringBuilder();
        char[] newStr = new char[len];
        for (int i = 0; i < len; i++) {
            if(i % 2 == 0) newStr[i/2] = word.charAt(i);
            else newStr[len - i/2 - 1] = word.charAt(i);
        }

        for (char c : newStr) {
            sb.append(c);
        }

        list.add(sb.toString());
        return sb.toString();
    }
}
