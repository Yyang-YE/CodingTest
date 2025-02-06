import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령으로 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int command = Integer.parseInt(st.nextToken());
            int[][] resultArr = {};
            if(command == 1) resultArr = firstTurn();
            if(command == 2) resultArr = secondTurn();
            if(command == 3) resultArr = thirdTurn();
            if(command == 4) resultArr = fourthTurn();
            if(command == 5) resultArr = fifthTurn();
            if(command == 6) resultArr = sixthTurn();

            // 설정 초기화
            arr = resultArr;
            N = arr.length;
            M =arr[0].length;
        }

        // 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                bw.append(String.valueOf(arr[i][j]));
                if(j != arr[0].length-1) bw.append(" ");
            }
            if(i != arr.length-1) bw.append("\n");
        }
        br.close();
        bw.close();
    }

    // 1번 연산
    public static int[][] firstTurn() {
        int[][] tempArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            tempArr[i] = arr[N - 1 - i];
        }
        return tempArr;
    }

    // 2번 연산
    public static int[][] secondTurn() {
        int[][] tempArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempArr[i][j] = arr[i][M - j - 1];
            }
        }
        return tempArr;
    }

    // 3번 연산
    public static int[][] thirdTurn() {
        int[][] tempArr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 0, 1 -> (4, 0)
                tempArr[i][j] = arr[N - j - 1][i];
            }
        }
        return tempArr;
    }

    // 4번 연산
    public static int[][] fourthTurn() {
        int[][] tempArr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 0, 1 -> (4, 0)
                tempArr[i][j] = arr[j][M - i - 1];
            }
        }
        return tempArr;

    }

    // 5번 연산
    public static int[][] fifthTurn() {
        int[][] tempArr = new int[N][M];
        int cutN = N/2;
        int cutM = M/2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int arrange = checkArrange(i, j);
                if(arrange == 1) tempArr[i][j] = arr[i+cutN][j];
                else if(arrange == 2) tempArr[i][j] = arr[i][j-cutM];
                else if(arrange == 3) tempArr[i][j] = arr[i-cutN][j];
                else if(arrange == 4) tempArr[i][j] = arr[i][j+cutM];
            }
        }
        return tempArr;
    }

    // 6번 연산
    public static int[][] sixthTurn() {
        int[][] tempArr = new int[N][M];
        int cutN = N/2;
        int cutM = M/2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int arrange = checkArrange(i, j);
                if(arrange == 1) tempArr[i][j] = arr[i][j+cutM];
                else if(arrange == 2) tempArr[i][j] = arr[i+cutN][j];
                else if(arrange == 3) tempArr[i][j] = arr[i][j-cutM];
                else if(arrange == 4) tempArr[i][j] = arr[i-cutN][j];
            }
        }
        return tempArr;
    }

    // 어떤 범위에 속해있는지 반환하는 메소드
    public static int checkArrange(int i, int j) {
        if(i < N/2 && j < M/2) return 1;
        else if(i < N/2 && j >= M/2) return 2;
        else if(i >= N/2 && j >= M/2) return 3;
        else return 4;
    }
}
