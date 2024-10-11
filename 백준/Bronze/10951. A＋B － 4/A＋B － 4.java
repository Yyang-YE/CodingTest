import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int num = 0;

        while(sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            array.add(a + b);
            num++;
        }

        for(int i = 0; i < num; i++) {
            System.out.println(array.get(i));
        }
        sc.close();
    }
}