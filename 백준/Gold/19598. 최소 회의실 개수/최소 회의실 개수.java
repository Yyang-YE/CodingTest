import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(s, e);
        }
        Arrays.sort(meetings);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(meetings[0].end);

        for (int i = 1; i < N; i++) {
            // end도 정렬되어 있음 ->
            if(!pq.isEmpty() && pq.peek() <= meetings[i].start) {
                pq.poll(); // 기존 강의실에서 가능 -> 이전거 빼고 새거 넣음
            }
            pq.add(meetings[i].end);
        }
        System.out.println(pq.size());
    }

    public static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting m) {
            if(this.start == m.start) return this.end - m.end;
            else return this.start - m.start;
        }
    }
}
