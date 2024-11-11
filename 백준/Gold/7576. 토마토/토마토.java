import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int M = Integer.parseInt(str.split(" ")[0]);
        int N = Integer.parseInt(str.split(" ")[1]);
        int[][] box = new int[N][M];
        Queue<int[]> matured = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int num =  Integer.parseInt(row[j]);
                box[i][j] = num;
                if (num == 1) matured.add(new int[]{i, j});
            }
        }

        int count = 0;
        while(true){
            if(Arrays.stream(box).flatMapToInt(Arrays::stream).allMatch(i -> i != 0)) {
                System.out.println(count);
                break;
            } else if(count == M * N - 1) {
                System.out.println(-1);
                break;
            }

            int len = matured.size();
            for (int k = 0; k < len; k++) {

                int[] index = matured.poll();
                int i = index[0];
                int j = index[1];

                if (j-1 >= 0 && box[i][j-1] == 0) {
                    box[i][j-1] = 1;
                    matured.add(new int[]{i, j-1});
                }
                if (j+1 < M && box[i][j+1] == 0) {
                    box[i][j+1] = 1;
                    matured.add(new int[]{i, j+1});
                }
                if (i-1 >= 0 && box[i-1][j] == 0) {
                    box[i-1][j] = 1;
                    matured.add(new int[]{i-1, j});
                }
                if (i+1 < N && box[i+1][j] == 0) {
                    box[i+1][j] = 1;
                    matured.add(new int[]{i+1, j});
                }
            }
            count++;
        }
    }
}