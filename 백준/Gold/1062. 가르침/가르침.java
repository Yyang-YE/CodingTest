import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static String[] words;
    static HashSet<Character> alphabet = new HashSet<>();
    static List<Character> tmp = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (!tmp.contains(c) && !isBasic(c)) tmp.add(c);
                alphabet.add(c);
            }
            words[i] = str.substring(4, str.length() - 4);
        }
        System.out.println(checkRead());
    }

    public static int checkRead() {
        if(K < 5) return 0;
        int alSize = tmp.size();
        if(alSize <= K-5) return N; // 전부 가르칠 수 있음

        int max = 0;
        // 배울 알파벳 선택
        for (int i = 0; i < (1 << alSize); i++) {
            if(Integer.bitCount(i) != K-5) continue;
            
            List<Character> learned = new ArrayList<>();
            for (int j = 0; j < alSize; j++) {
                if((i & (1 << j)) != 0) learned.add(tmp.get(j));
            }

            // 알파벳 확인하기
            int cnt = 0;
            for (String word : words) {
                boolean canRead = true;
                for (char c : word.toCharArray()) {
                    if(!learned.contains(c) && !isBasic(c)) {
                        canRead = false;
                        break;
                    }
                }
                if(canRead) {
                    cnt++;
                }
            }
            max = Math.max(cnt, max);
        }
        return max;
    }

    private static boolean isBasic(char c) {
        return c == 'a' || c == 'n' || c == 't' || c == 'i' || c == 'c';
    }
}
