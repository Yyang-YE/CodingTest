import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String[]> members = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            members.add(br.readLine().split(" "));
        }

        members.sort(Comparator.comparingInt((String[] a) -> Integer.parseInt(a[0])));

        for (String[] member : members) {
            System.out.println(member[0] + " " + member[1]);
        }
    }
}