import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] dictionary = new String[N];
        for (int i = 0; i < N; i++) {
            dictionary[i] = br.readLine();
        }
        Arrays.sort(dictionary, Comparator.comparing(String::length).thenComparing(String::compareTo));

        String temp = "";
        for (int i = 0; i < N; i++) {
            if(!temp.equals(dictionary[i])) {
                bw.write(dictionary[i] + "\n");
            }
            temp = dictionary[i];
        }
        bw.flush();
        br.close();
        bw.close();
    }
}