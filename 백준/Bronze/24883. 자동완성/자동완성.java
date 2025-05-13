import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String alphabet = sc.nextLine();
		if(alphabet.equals("N") || alphabet.equals("n")) System.out.println("Naver D2");
		else System.out.println("Naver Whale");
	}
}
