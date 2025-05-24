import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            answer.clear();
            dfs(N, 1, 2, 1, new StringBuilder("1")); // 시작 숫자는 1
            Collections.sort(answer);
            for (String s : answer) {
                bw.write(s + "\n");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    public static void dfs(int N, int sum, int idx, int prefix, StringBuilder formula) throws IOException {
        if (idx > N) {
            if (sum == 0) {
                answer.add(formula.toString());
            }
            return;
        }

        // + 연산
        StringBuilder tmp = new StringBuilder(formula);
        dfs(N, sum + idx, idx + 1, idx, tmp.append("+").append(idx));

        // - 연산
        tmp = new StringBuilder(formula);
        dfs(N, sum - idx, idx + 1, -idx, tmp.append("-").append(idx));

        // 공백 (숫자 이어붙이기) : 이전에 sum에 더한 수를 prefix에 넣기, 한번 더 해야하면 뺴고 새 값 넣기
        tmp = new StringBuilder(formula);
        int concat = prefix >= 0 ? prefix * 10 + idx : prefix * 10 - idx;
        dfs(N, sum - prefix + concat, idx + 1, concat, tmp.append(" ").append(idx));
    }
}
