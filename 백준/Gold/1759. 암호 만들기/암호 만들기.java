import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] alphabets;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabets);

        dfs(0, 0, new StringBuilder());
        br.close();
        bw.close();
    }

    private static void dfs(int idx, int depth, StringBuilder sb) throws IOException {
        if(depth == L) {
            int vowelCount = 0;
            for (int i = 0; i < L; i++) {
                if(isVowel(sb.charAt(i))) vowelCount++;
            }
            
            if(sb.length() - vowelCount >= 2 && vowelCount >= 1) {
                bw.write(sb + "\n");
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            sb.append(alphabets[i]);
            dfs(i + 1, depth + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
