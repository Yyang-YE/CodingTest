import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        int curNum = 666; // 최소부터 시작
        
        while(count != N) {
            if(String.valueOf(curNum).contains("666")) {
                count++;
            }
            curNum++;
        }
        System.out.println(curNum - 1);
    }
}
