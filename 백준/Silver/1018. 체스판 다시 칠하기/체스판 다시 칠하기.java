import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String[][] arr = new String[N][M];
        int[][] wArr = new int[N][M]; // WBWB순
        int[][] bArr = new int[N][M]; // BWBW순

        // 배열 초기화
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    wArr[i][j] = arr[i][j].equals("W") ? 0 : 1;
                    bArr[i][j] = arr[i][j].equals("B") ? 0 : 1;
                } else {
                    wArr[i][j] = arr[i][j].equals("B") ? 0 : 1;
                    bArr[i][j] = arr[i][j].equals("W") ? 0 : 1;
                }
            }
        }

        int wMin = 0;
        int bMin = 0;
        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                //체스판 총 수정 수
                int wTemp = 0;
                int bTemp = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        wTemp += wArr[i+k][j+l];
                        bTemp += bArr[i+k][j+l];
                    }
                }

                if(i == 0 && j == 0) {
                    wMin = wTemp;
                    bMin = bTemp;
                } else {
                    wMin = Math.min(wTemp, wMin);
                    bMin = Math.min(bTemp, bMin);
                }
            }
        }
        System.out.println(Math.min(wMin, bMin));
    }
}