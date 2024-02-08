import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[26];
        char[] carr = str.toCharArray();

        for(int i=0; i<26; i++) {
            arr[i] = -1;
        }

        for(int i=0; i<carr.length; i++) {
            if(arr[(int)carr[i]-97] == -1) {
                arr[(int)carr[i]-97] = i;
            }
        }

        for(int i=0; i<26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}