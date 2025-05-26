import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String formula = br.readLine();

        List<Pair> pairs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < formula.length(); i++) {
            if(formula.charAt(i) == '(') stack.push(i);
            else if(formula.charAt(i) == ')') {
                int sIdx = stack.pop();
                pairs.add(new Pair(sIdx, i));
            }
        }

        // 조합마다 결과 저장 (전체 있는 경우 제외)
        TreeSet<String> set = new TreeSet<>();
        for (int i = 1; i < (1 << pairs.size()); i++) {
            List<Integer> selected = new ArrayList<>();
            for (int j = 0; j < pairs.size(); j++) {
                if((i & (1 << j)) != 0) {
                    selected.add(pairs.get(j).start);
                    selected.add(pairs.get(j).end);
                }
            }
            Collections.sort(selected);

            // 각 조합에서 삭제한 결과 저장
            int pull = 0;
            StringBuilder sb = new StringBuilder(formula);
            for (int idx : selected) {
                sb.deleteCharAt(idx - pull);
                pull++;
            }
            set.add(sb.toString());
        }

        for (String s : set) {
            bw.write(s + "\n");
        }
        br.close();
        bw.close();
    }

    public static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
