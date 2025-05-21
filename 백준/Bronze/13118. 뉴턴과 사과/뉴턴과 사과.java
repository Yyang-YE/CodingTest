import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] people = br.readLine().split(" ");
		String[] info = br.readLine().split(" ");

		String str = "0";
		for (int i = 0; i < people.length; i++) {
			if(people[i].equals(info[0])) {
				str = String.valueOf(i + 1);
				break;
			}
		}
		System.out.println(str);
	}
}