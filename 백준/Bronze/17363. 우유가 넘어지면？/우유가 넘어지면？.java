import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Character, Character> map = getMap();
        char[][] turned = new char[M][N];

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                turned[j][i] = map.get(tmp[M - j - 1]);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(turned[i][j]);
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    public static Map<Character, Character> getMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('.', '.');
        map.put('O', 'O');
        map.put('-', '|');
        map.put('|', '-');
        map.put('/', '\\');
        map.put('\\', '/');
        map.put('^', '<');
        map.put('<', 'v');
        map.put('v', '>');
        map.put('>', '^');
        return map;
    }
}
