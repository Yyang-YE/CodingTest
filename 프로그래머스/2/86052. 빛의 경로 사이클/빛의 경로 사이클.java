import java.util.*;
import java.io.*;

class Solution {
    static int N, M;
    static char[][] board;
    static boolean[][][] visited; // 상하좌우 방문했는지 체크
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    // 하 상 우 좌
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int[] solution(String[] grid) {
        // 전역변수화
        N = grid.length;
        M = grid[0].length();
        visited = new boolean[N][M][4];
        board = new char[N][M];
        
        for(int i = 0; i < N; i++) {
            board[i] = grid[i].toCharArray();
        }
        
        // 검증 (최악의 경우 백만건)
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < 4; k++) {
                    if(!visited[i][j][k]) {
                        dfs(new Info(i, j, k));
                    }
                }
            }
        }
        
        int len = pq.size();
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
    
    // 시작 위치 & 방향을 다시 만나면 사이클
    // 사이클이라면 visited 처리, 정답 기록 (탐색 횟수 줄이기)
    public void dfs(Info now) {
        int depth = 0;
        while (!visited[now.x][now.y][now.way]) {
            visited[now.x][now.y][now.way] = true;
            Info n = new Info(0, 0, 0);
            
            // 다음 방향 지정
            if(board[now.x][now.y] == 'S') {
                n.way = now.way;
            } else if(board[now.x][now.y] == 'L') {
                if(now.way == 0) n.way = 3;
                else if(now.way == 1) n.way = 2;
                else if(now.way == 2) n.way = 0;
                else n.way = 1;
            } else { // R
                if(now.way == 0) n.way = 2;
                else if(now.way == 1) n.way = 3;
                else if(now.way == 2) n.way = 1;
                else n.way = 0;
            }

            // 다음 좌표 지정
            n.x = now.x + dx[n.way];        
            if(n.x < 0) n.x = N - 1;
            else if(n.x >= N) n.x = 0;

            n.y = now.y + dy[n.way];
            if(n.y < 0) n.y = M - 1;
            else if(n.y >= M) n.y = 0;

            now = n;
            depth++;
        }
        pq.offer(depth);
    }
    
    public class Info {
        int x;
        int y;
        int way;
        
        public Info(int x, int y, int way) {
            this.x = x;
            this.y = y;
            this.way = way;
        }
    }
}