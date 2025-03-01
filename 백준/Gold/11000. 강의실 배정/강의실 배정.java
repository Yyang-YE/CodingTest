import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Lesson[] lessons = new Lesson[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lessons[i] = new Lesson(s, e);
        }

        // 시작 시간 기준으로 정렬 -> 같다면 종료 시간 기준으로 정렬
        Arrays.sort(lessons, (l1, l2) ->
                    l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lessons[0].end);
        for (int i = 1; i < N; i++) {
            if(pq.peek() <= lessons[i].start) {
                pq.poll(); // 넣는게 가능하면 해당 강의실 끝 시간을 바꿈
            }
            pq.offer(lessons[i].end);
        }
        System.out.println(pq.size());
    }

    public static class Lesson {
        int start;
        int end;

        public Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
