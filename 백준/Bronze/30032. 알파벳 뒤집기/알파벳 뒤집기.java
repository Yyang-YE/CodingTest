import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 'd') {
                    if(D == 1) bw.write('q');
                    else bw.write('b');
                } else if(arr[i][j] == 'b') {
                    if(D == 1) bw.write('p');
                    else bw.write('d');
                } else if(arr[i][j] == 'q') {
                    if(D == 1) bw.write('d');
                    else bw.write('p');
                } else if (arr[i][j] == 'p') {
                    if(D == 1) bw.write('b');
                    else bw.write('q');
                }
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
