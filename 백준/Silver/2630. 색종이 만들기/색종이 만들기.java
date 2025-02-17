import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] paper;
    static int whiteCount;
    static int blueCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        cutPaper(0, 0, N);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static boolean checkColor(int sX, int sY, int len) {
        int flag = paper[sX][sY];
        for (int i = sX; i < sX + len; i++) {
            for (int j = sY; j < sY + len; j++) {
                if(paper[i][j] != flag) return false;
            }
        }
        return true;
    }

    private static void cutPaper(int sX, int sY, int len) {
        // 받은 종이가 다른 색이면 cut하기
        if(!checkColor(sX, sY, len)) {
            int newLen = len/2;
            cutPaper(sX, sY, newLen);
            cutPaper(sX+newLen, sY, newLen);
            cutPaper(sX, sY+newLen, newLen);
            cutPaper(sX+newLen, sY+newLen, newLen);
        } else { // 전부 같은 색
            if(paper[sX][sY] == 0) whiteCount++;
            else blueCount++;
        }
    }
}
