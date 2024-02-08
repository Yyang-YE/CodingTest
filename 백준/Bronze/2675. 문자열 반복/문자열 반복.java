import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<String>();
        int N = sc.nextInt();
        int num;
        String str;
        String temp = "";

        for(int i=0; i<N; i++) {
            num = sc.nextInt();
            str = sc.nextLine();

            if(!temp.isEmpty()) {
                temp = "";
            }
            for (int j = 0; j < str.length()-1; j++) {
                for (int k=0; k < num; k ++) {
                    temp = temp + str.charAt(j+1);
                }
            }
            al.add(temp);
        }
        for(int i=0; i<N; i++) {
            System.out.println(al.get(i));
        }
    }
}