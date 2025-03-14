import java.io.*;
import java.util.*;

public class Solution {
    static Atom[] atoms;
    // 거리 작은 순으로 정렬
    static PriorityQueue<Crush> crushes = new PriorityQueue<>(
        Comparator.comparingDouble((Crush c) -> c.distance)
            .thenComparingDouble(c -> c.x)
            .thenComparingDouble(c -> c.y)
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine()); // 원자 수
            atoms = new Atom[N];

            // 정보 입력받기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                atoms[i] = new Atom(x, y, w, e);
            }

            // 충돌가능 지점 구하기 (모든 조합에 대해 가능성 고려)
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    Crush crush = checkCrush(i, j);

                    if(crush.x != 1001 && crush.distance != 0) { // 충돌 가능 좌표들 저장
                        crushes.add(crush);
                    }
                }
            }

            // 돌면서 확인
            double x = 1001;
            double y = 1001;
            double dist = 2001;
            int totalEnergy = 0;
            boolean[] crushed = new boolean[N];
            Set<Integer> set = new HashSet<>(); // 현재 좌표에서
            while (!crushes.isEmpty()) {
                Crush now = crushes.poll();
                // 좌표, 거리가 같으면 동시 충돌
                if(x == now.x && y == now.y && dist == now.distance) {
                    // 좌표에서의 충돌은 이미 일어남 -> 둘 중 하나라도 도달 가능하면 crush
                    if(!crushed[now.a1]) set.add(now.a1); crushed[now.a1] = true;
                    if(!crushed[now.a2]) set.add(now.a2); crushed[now.a2] = true;
                } else { // 새로운 좌표의 충돌
                    if(!crushed[now.a1] && !crushed[now.a2]) {
                        // set 돌면서 각각의 에너지 더하기
                        for (int i : set) {
                            totalEnergy += atoms[i].energy;
                        }

                        // 충돌 좌표 초기화
                        x = now.x;
                        y = now.y;
                        dist = now.distance;

                        // set 초기화
                        set.clear();
                        set.add(now.a1);
                        set.add(now.a2);

                        // 충돌 여부 설정
                        crushed[now.a1] = true;
                        crushed[now.a2] = true;
                    }
                }
            }
            // 마지막으로 넣기
            for (int i : set) {
                totalEnergy += atoms[i].energy;
            }
            bw.write("#" + tc + " " + totalEnergy + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    // 가능하면 충돌 x, y 좌표 변함
    public static Crush checkCrush(int idx1, int idx2) {
        Crush crush = new Crush(idx1, idx2, 1001, 1001, 0);
        Atom a1 = atoms[idx1];
        Atom a2 = atoms[idx2];

        // 충돌 좌표 구하기
        switch (a1.way) {
            case 0: // 상
                if(a1.y < a2.y) {
                    if((a1.x < a2.x && a2.way == 2) || (a1.x > a2.x && a2.way == 3)) { // 좌, 우
                        crush.x = a1.x;
                        crush.y = a2.y;
                    }
                    else if(a1.x == a2.x && a2.way == 1) { // 하
                        crush.x = a1.x;
                        crush.y = a1.y + (((double) a2.y - a1.y) / 2);
                    }
                }
                break;
            case 1: // 하
                if(a1.y > a2.y) {
                    if((a1.x < a2.x && a2.way == 2) || (a1.x > a2.x && a2.way == 3)) { // 좌, 우
                        crush.x = a1.x;
                        crush.y = a2.y;
                    }
                    else if(a1.x == a2.x && a2.way == 0) { // 상
                        crush.x = a1.x;
                        crush.y = a2.y + (((double) a1.y - a2.y) / 2);
                    }
                }
                break;
            case 2: // 좌
                if(a1.x > a2.x) {
                    if((a1.y < a2.y && a2.way == 1) || (a1.y > a2.y &&  a2.way == 0)) { //상, 하
                        crush.x = a2.x;
                        crush.y = a1.y;
                    } else if (a1.y == a2.y && a2.way == 3) {
                        crush.x = a2.x + (((double) a1.x - a2.x) / 2);
                        crush.y = a1.y;
                    }
                }
                break;
            case 3: // 우
                if(a1.x < a2.x) {
                    if((a1.y < a2.y && a2.way == 1) || (a1.y > a2.y &&  a2.way == 0)) { //상, 하
                        crush.x = a2.x;
                        crush.y = a1.y;
                    } else if (a1.y == a2.y && a2.way == 2) {
                        crush.x = a1.x + (((double) a2.x - a1.x) / 2);
                        crush.y = a1.y;
                    }
                }
                break;
        }

        // 거리로 충돌 확인
        if(Math.abs((double) a1.x-a2.x) == Math.abs((double) a1.y-a2.y)) {
            crush.distance = Math.abs((double) a1.x-a2.x);
        } else if(a1.y == a2.y && ((a1.x > a2.x && a2.way == 3 && a1.way == 2) || (a1.x < a2.x && a2.way == 2 && a1.way == 3))) {
            crush.distance = Math.abs(((double) a2.x - a1.x) / 2);
        } else if(a1.x == a2.x && ((a1.y > a2.y && a2.way == 0 && a1.way == 1) || (a1.y < a2.y && a2.way == 1 && a1.way == 0))) {
            crush.distance = Math.abs(((double) a1.y - a2.y) / 2);
        }

        return crush;
    }

    public static class Crush {
        int a1;
        int a2;
        double x;
        double y;
        double distance;

        public Crush(int a1, int a2, double x, double y, double distance) {
            this.a1 = a1;
            this.a2 = a2;
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static class Atom {
        int x;
        int y;
        int way;
        int energy;

        public Atom(int x, int y, int way, int energy) {
            this.x = x;
            this.y = y;
            this.way = way;
            this.energy = energy;
        }
    }
}
