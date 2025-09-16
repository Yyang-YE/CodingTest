import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String f = sc.nextLine();
        String s = sc.nextLine();
        String t = sc.nextLine();

        long answer = (getNum(f) * 10L + getNum(s));
        int time = getNum(t);
        while(time > 0) {
            answer *= 10L;
            time--;
        }
        System.out.println(answer);
    }

    public static int getNum(String color) {
        if(color.equals("black")) return 0;
        else if(color.equals("brown")) return 1;
        else if(color.equals("red")) return 2;
        else if(color.equals("orange")) return 3;
        else if(color.equals("yellow")) return 4;
        else if(color.equals("green")) return 5;
        else if(color.equals("blue")) return 6;
        else if(color.equals("violet")) return 7;
        else if(color.equals("grey")) return 8;
        else return 9;
    }
}
