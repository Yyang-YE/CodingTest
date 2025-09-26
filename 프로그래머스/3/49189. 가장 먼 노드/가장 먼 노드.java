import java.util.*;
import java.io.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;
    public int solution(int n, int[][] edge) {
        // 초기화
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            distance[i] = INF;
        }
        
        // 그래프 생성
        for(int[] e : edge) {
            graph.get(e[0]).add(new Node(e[1], 1));
            graph.get(e[1]).add(new Node(e[0], 1));
        }
        
        // 최단경로 탐색 (1번 기준)
        dijkstra();
        
        int count = 0;
        int max = 0;
        for(int i = 2; i <= n; i++) {
            if(distance[i] == INF) continue;
            
            if(distance[i] == max) {
                count++;
            } else if(distance[i] > max) {
                max = distance[i];
                count = 1;
            }
        }
        return count;
    }
    
    // distance 채우기
    public void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.cost));
        
        distance[1] = 0;
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(!visited[cur.idx]) visited[cur.idx] = true;
            else continue;
            
            for(Node next : graph.get(cur.idx)) {
                if(!visited[next.idx] && distance[next.idx] > cur.cost + next.cost) {
                    distance[next.idx] = cur.cost + next.cost;
                    pq.offer(new Node(next.idx, distance[next.idx]));
                }
            }
        }
    }
    
    public class Node {
        int idx;
        int cost;
        
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}