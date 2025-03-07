import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if(word.length() == 1) {
                count++;
                continue;
            }

            Set<Character> set = new HashSet<>();
            char before = word.charAt(0);
            set.add(before);
            for (int j = 1; j < word.length(); j++) {
                char c = word.charAt(j);
                if(c != before) {
                    if(set.contains(c)) {
                        break;
                    } else {
                        before = c;
                        set.add(c);
                    }
                }
                if(j == word.length()-1) count++;
            }
        }
        System.out.println(count);
    }
}
