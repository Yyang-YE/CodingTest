import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> list = new LinkedList<>();
        int as = 0;
        int bs = 0;
        while(true) {
            int max = findMax(A.clone(), B.clone()); // 값
            if(max > 0) { // -1이 아니면
                list.add(max); // 수는 동일
                // A, B갱신
                as = updateArray(N, A, as, max);
                bs = updateArray(M, B, bs, max);
            } else break;
        }
        sb.append(list.size()).append("\n");
        for (int i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static int updateArray(int len, int[] arr, int start, int max) {
        for (int i = start; i < len; i++) {
            if(arr[i] == max) {
                arr[i] = -1;
                start = i + 1;
                break;
            } else {
                arr[i] = -1;
            }
        }
        return start;
    }

    public static int findMax(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = A.length-1; i >= 0; i--) {
            for (int j = B.length-1; j >= 0; j--) {
                if(A[i] == B[j]) return A[i];
            }
        }
        return -1;
    }
}
