import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] usedNumber = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        String s = sc.nextLine();
        for (char c : s.toCharArray()) {
            usedNumber[Character.toUpperCase(c) - 'A']++;
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < 26; i++) {
            if(usedNumber[i] > max) {
                max = usedNumber[i];
                maxIndex = i;
            } else if (usedNumber[i] == max) {
                maxIndex = -1;
            }
        }

        if (maxIndex == -1) {
            System.out.println("?");
        } else {
            System.out.println((char) (maxIndex + 'A'));
        }
    }
}