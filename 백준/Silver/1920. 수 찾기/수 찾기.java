import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 첫번째 입력
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // 두번째 입력
        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int key = sc.nextInt();
            sb.append(binarySearch(arr, key)).append('\n');
        }

        // 결과 출력
        System.out.println(sb);
    }
    
    private static int binarySearch(int[] arr, int key) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex <= rightIndex) {
            int index = (leftIndex + rightIndex) / 2;

            if (arr[index] == key) {
                return 1;
            } else if (arr[index] < key) {
                leftIndex = index + 1;
            } else {
                rightIndex = index - 1;
            }
        }
        return 0;
    }
}