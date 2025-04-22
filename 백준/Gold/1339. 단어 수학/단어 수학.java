import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        Count[] info = new Count[26];
        for (int i = 0; i < 26; i++) {
            info[i] = new Count((char) ('A' + i), 0);
        }

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();

            int mul = 1;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                char c = words[i].charAt(j);
                info[c-'A'].score += mul;
                mul *= 10;
            }
        }
        Arrays.sort(info, Comparator.comparing(c -> c.score));

        int num = 9;
        for (int i = 25; i >= 16; i--) {
            char c = info[i].c;
            for (int j = 0; j < words.length; j++) {
                words[j] = words[j].replace(c, (char) ('0' + num));
            }
            num--;
        }
        long sum = 0L;
        for (String word : words) {
            sum += Long.parseLong(word);
        }
        System.out.println(sum);
    }

    public static class Count {
        char c;
        long score;

        public Count(char c, long score) {
            this.c = c;
            this.score = score;
        }
    }
}
