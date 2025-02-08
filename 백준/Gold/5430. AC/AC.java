import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Deque<String> deque= new LinkedList<>();
            String command = br.readLine();
            boolean isPointerFirst = true;
            boolean isError = false;
            br.readLine();
            String[] temp = br.readLine().split(",");

            if(temp[0].equals("[]")) {
                if(command.contains("D")) isError = true;
            } else {
                for (int j = 0; j < temp.length; j++) {
                    if (j == 0) temp[j] = temp[j].substring(1);
                    if (j == temp.length - 1) temp[j] = temp[j].substring(0, temp[j].length() - 1);
                    deque.offer(temp[j]);
                }

                for (char c : command.toCharArray()) {
                    if (c == 'R') {
                        isPointerFirst = !isPointerFirst;
                    }
                    if (c == 'D') {
                        if (deque.isEmpty()) {
                            isError = true;
                            break;
                        }
                        if (isPointerFirst) deque.removeFirst();
                        else deque.removeLast();
                    }
                }
            }

            if(isError) bw.append("error");
            else if(deque.isEmpty()) bw.append("[]");
            else {
                bw.append("[");
                int count = deque.size();
                for (int j = 0; j < count; j++) {
                    if(isPointerFirst) bw.append(deque.pollFirst());
                    else bw.append(deque.pollLast());
                    if(j != count - 1) bw.append(",");
                }
                bw.append("]");
            }
            if(i != T-1) bw.append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
