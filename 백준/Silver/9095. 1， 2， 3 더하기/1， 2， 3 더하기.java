import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            int result = 0;
            int N = Integer.parseInt(sc.nextLine());
            int countOne;
            int countTwo;
            int countThree = 0;

            while(true) {
                int tempN = N;
                countTwo = 0;
                
                while(true) {
                    countOne = tempN;
                    result += countCases(countOne, countTwo, countThree);
                    if(tempN - 2 >= 0) {
                        tempN -= 2;
                        countTwo++;
                    } else {
                        break;
                    }
                }
                
                if (N - 3 >= 0) {
                    N -= 3;
                    countThree++;
                } else {
                    break;
                }
            }
            sb.append(result);
            if(i != T - 1) sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int countCases(int oneNUm, int twoNum, int threeNum) {
        int bunja = getFactorial(oneNUm + twoNum + threeNum);
        int oneBunmo = oneNUm != 0 ? getFactorial(oneNUm) : 1;
        int twoBunmo = twoNum != 0 ? getFactorial(twoNum) : 1;
        int threeBunmo = threeNum != 0 ? getFactorial(threeNum) : 1;

        return bunja / (oneBunmo * twoBunmo * threeBunmo);
    }
    
    private static int getFactorial(int Num) {
        int result = 1;
        for (int i = 2; i <= Num; i++) {
            result *= i;
        }
        return result;
    }
}