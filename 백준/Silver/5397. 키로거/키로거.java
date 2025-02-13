import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            LinkedList<String> pw = new LinkedList<>();
            ListIterator<String> cursor = pw.listIterator();
            int index = 0;
            for (char c : command.toCharArray()) {
                if(c == '<') {
                    if(cursor.hasPrevious()) {
                        cursor.previous();
                    }
                } else if(c == '>') {
                    if(cursor.hasNext()) {
                        cursor.next();
                    }
                } else if(c == '-') {
                    if(cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                } else {
                    cursor.add(String.valueOf(c));
                }
            }
            for (String s : pw) {
                bw.write(s);
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
