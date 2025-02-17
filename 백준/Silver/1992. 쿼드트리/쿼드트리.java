import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = String.valueOf(str.charAt(j));
            }
        }

        while(map.length != 1) {
            compress();
        }
        System.out.println(map[0][0]);
    }

    public static void compress() {
        int newN = map.length/2;
        String[][] newMap = new String[newN][newN];

        for (int i = 0; i < map.length; i+=2) {
            for (int j = 0; j < map.length; j+=2) {
                // 만약 4칸이 전부 같다면
                if(map[i][j].length() == 1 && map[i][j].equals(map[i][j+1]) && map[i][j].equals(map[i+1][j]) && map[i][j].equals(map[i+1][j+1])) {
                    newMap[i/2][j/2] = map[i][j];
                } else {
                    newMap[i/2][j/2] = "(" + map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1] + ")";
                }
            }
        }
        // map 재설정
        map = newMap;
    }
}
