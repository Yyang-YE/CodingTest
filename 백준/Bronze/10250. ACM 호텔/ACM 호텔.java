import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        sc.nextLine();

        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int floor = (N - 1) % H + 1;
            int roomNum = (N - 1) / H + 1;

            String roomNumStr = roomNum < 10 ? "0" + roomNum : Integer.toString(roomNum);
            results[i] = floor + roomNumStr;
        }

        for (int i = 0; i < T; i++) {
            System.out.println(results[i]);
        }
    }
}