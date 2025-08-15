import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String addr = expandColon(br.readLine());
        String[] arr = addr.split(":", -1);

        for (int i = 0; i < 8; i++) {
            if(arr[i].replace("0", "").isEmpty()) sb.append("0000");
            else if(arr[i].length() < 4) sb.append(getRepeat(4 - arr[i].length(), "0")).append(arr[i]);
            else sb.append(arr[i]);

            if(i < 7) sb.append(":");
        }
        System.out.println(sb);
    }

    private static String expandColon(String original) {
        int colonCnt = original.length() - original.replace(":", "").length();
        if(colonCnt < 7) {
            return original.replace("::", getRepeat(9 - colonCnt, ":"));
        } else if(colonCnt > 7) {
            return original.replace("::", ":");
        }
        return original;
    }

    private static String getRepeat(int count, String str) {
        return String.join("", java.util.Collections.nCopies(count, str));
    }
}
