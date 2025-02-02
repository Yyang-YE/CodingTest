import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int whiteCount = 0;
    static int blueCount = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checkPaper(N, 0, 0);
        System.out.println(whiteCount + "\n" + blueCount);
    }
    
    public static void checkPaper(int N, int xStart, int yStart) {
        boolean wFlag = false;
        boolean bFlag = false;

        for (int i = xStart; i < xStart + N; i++) {
            for (int j = yStart; j < yStart + N; j++) {
                if(paper[i][j] == 1) {
                    bFlag = true;
                } else {
                    wFlag = true;
                }
            }
            if(bFlag && wFlag) break;
        }

        // 둘 다 섞여있으면 4등분
        if(bFlag && wFlag) {
            int newN = N/2;
            checkPaper(newN, xStart, yStart);
            checkPaper(newN, xStart + newN, yStart);
            checkPaper(newN, xStart, yStart + newN);
            checkPaper(newN, xStart + newN, yStart + newN);
        } else if(wFlag) { // white로만 이루어진 경우
            whiteCount++;
        } else if(bFlag) { // blue로만 이루어진 경우
            blueCount++;
        }
    }
}