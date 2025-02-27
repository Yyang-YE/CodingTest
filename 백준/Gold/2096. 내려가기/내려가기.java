import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 0번째값 업데이트
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        Line minDP = new Line(l, m, r);
        Line maxDP = new Line(l, m, r);

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            // temp 만들기
            Line tempMin = new Line(l, m, r);
            Line tempMax = new Line(l, m, r);

            //minDP 갱신
            tempMin.left += Math.min(minDP.left, minDP.mid);
            tempMin.mid += Math.min(minDP.left, Math.min(minDP.mid, minDP.right));
            tempMin.right += Math.min(minDP.mid, minDP.right);

            //maxDP 갱신
            tempMax.left += Math.max(maxDP.left, maxDP.mid);
            tempMax.mid += Math.max(maxDP.left, Math.max(maxDP.mid, maxDP.right));
            tempMax.right += Math.max(maxDP.mid, maxDP.right);

            // 업데이트
            minDP = new Line(tempMin.left, tempMin.mid, tempMin.right);
            maxDP = new Line(tempMax.left, tempMax.mid, tempMax.right);;
        }
        int max = Math.max(maxDP.left, Math.max(maxDP.mid, maxDP.right));
        int min = Math.min(minDP.left, Math.min(minDP.mid, minDP.right));
        System.out.println(max + " " + min);
    }

    public static class Line {
        int left;
        int mid;
        int right;
        public Line(int left, int mid, int right) {
            this.left = left;
            this.mid = mid;
            this.right = right;
        }
    }
}
