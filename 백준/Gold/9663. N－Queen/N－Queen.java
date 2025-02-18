import java.util.Scanner;

public class Main {
    static int[] map;
    static int count, N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        // 현재 좌표 기준 invalid 체크
        for (int i = 0; i < N; i++) {
            map[depth] = i;

            // queen의 위치가 i여도 되면 다음 queen 놓기
            if(checkPossibility(depth)) {
                nQueen(depth+1);
            }
        }
    }

    private static boolean checkPossibility(int col) {
        for (int i = 0; i < col; i++) {
            if(map[col] == map[i]) return false;
            if(Math.abs(col-i) == Math.abs(map[col] - map[i])) return false;
        }
        return true;
    }
}
