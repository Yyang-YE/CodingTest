import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][5][7];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = br.readLine().toCharArray();
            }
        }

        int[] answer = new int[2];
        int min = 40;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int diff = getDiff(i, j);
                if(min > diff) {
                    min = diff;
                    answer = new int[]{i+1, j+1};
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }

    private static int getDiff(int a, int b) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if(arr[a][i][j] != arr[b][i][j]) count++;
            }
        }
        return count;
    }
}
