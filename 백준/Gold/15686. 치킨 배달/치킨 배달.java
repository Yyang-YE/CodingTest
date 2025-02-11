import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count = 0;
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] isVisited;

    static List<Coordinate> houses = new ArrayList<>();
    static List<Coordinate> chickens = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 1) {
                    houses.add(new Coordinate(i, j));
                } else if(temp == 2) {
                    chickens.add(new Coordinate(i, j));
                }
            }
        }

        isVisited = new boolean[chickens.size()];

        for (int i = 0; i < chickens.size(); i++) {
            if(!isVisited[i]) {
                selectChicken(0, 0);
                count++;
            }
        }
        System.out.println(answer);
    }

    public static void selectChicken(int least, int depth) {
        if(depth == M) { // 전부 찾은 경우
            int tempAnswer = 0;
            for (int i = 0; i < houses.size(); i++) {
                int minVal = Integer.MAX_VALUE; // 치킨집과의 최소 거리
                for (int j = 0; j < chickens.size(); j++) {
                    if (isVisited[j]) {
                        int temp = Math.abs(houses.get(i).x - chickens.get(j).x) + Math.abs(houses.get(i).y - chickens.get(j).y);
                        minVal = Math.min(minVal, temp);
                    }
                }
                tempAnswer += minVal;
            }
            // 구한 값 & answer 중 최소를 답으로
            answer = Math.min(answer, tempAnswer);
        }

        // 조합 찾기
        for (int i = least; i < chickens.size(); i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                selectChicken(i+1, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
