import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] wrd = str.split(" ");
        ArrayList<String> words = new ArrayList<String>();

        for(int i=0; i<wrd.length; i++) {
            if(!wrd[i].isEmpty()) {
                words.add(wrd[i]);
            }
        }
        System.out.println(words.size());
    }
}