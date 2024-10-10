import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = sc.nextLine();
            if (str.equals("0 0 0")) break;

            int[] arr = Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            Arrays.sort(arr);

            if(arr[2]*arr[2] == arr[0]*arr[0] + arr[1]*arr[1]) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}