import java.io.*;
import java.util.*;

public class Main {
	static int N, Q;
	static int[] size;
	static int[][] board;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		board = new int[N+1][N+1];
		size = new int[Q + 1]; // Q번째 요소의 현재 크기 관리
		for(int i = 1; i <= Q; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			// 미생물 추가
			size[i] = (r2 - r1) * (c2 - c1);
			for(int j = c1 + 1; j <= c2; j++) {
				for(int k = r1 + 1; k <= r2; k++) {
					if(board[j][k] != 0) {
						size[board[j][k]]--; // 겹치면 크기 감소
					}
					board[j][k] = i; // 미생물 부여
				}
			}
			
			// 잘림 확인(잘리면 사라짐)
			checkCut();
			
			// 용기 이동
			move(i);
			
			// 크기 확인
			if(i == 1) bw.write("0\n"); // 처음은 안겹침
			else bw.write(getResult() + "\n");
		}
		
		// 정답
		br.close();
		bw.flush();
		bw.close();
	}

  // 1. 잘린 미생물 제거
	public static void checkCut() {
		boolean[] checkM = new boolean[Q + 1]; // n번째 요소, 확인되었는지
		boolean[][] visited = new boolean[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				// 비거나 이미 돌았으면 넘어감
				if(board[i][j] == 0 || visited[i][j]) continue;
				
				// 만약 이미 돌았는데 또 있으면 잘린 것!
				if(checkM[board[i][j]]) {
					size[board[i][j]] = 0;
				} else {
					checkM[board[i][j]] = true;
				}
				
				// 뭉탱이 방문 처리
				Queue<Point> pq = new LinkedList<>();
				visited[i][j] = true;
				pq.offer(new Point(i, j));
				while(!pq.isEmpty()) {
					Point now = pq.poll();
					
					// 상하좌우 확인
					for(int k = 0; k < 4; k++) {
						int nx = now.x + dx[k];
						int ny = now.y + dy[k];
						if(checkArrange(nx, ny) && !visited[nx][ny] && board[nx][ny] == board[i][j]) {
							visited[nx][ny] = true;
							pq.add(new Point(nx, ny));
						}
					}
				}
			}
		}
	}
	
	// 2. 배양 용기 이동
	public static void move(int m) {
		// 우선순위 정하기
		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(Info::getSize).reversed().thenComparing(Info::getIdx));
		for(int j = 1; j <= m; j++) { // 현재 기준 이동
			if(size[j] != 0) pq.offer(new Info(j, size[j]));
		}
		
		// 하나씩 이동
		int[][] tmpB = new int[N+1][N+1];
		while(!pq.isEmpty()) {
			Info now = pq.poll();
			
			// 형태 뽑아내기
			int lx = 100, ly = 100, rx = 0, ry = 0;
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(now.idx == board[i][j]) {
						cnt++;
						lx = Math.min(lx, i);
						ly = Math.min(ly, j);
						rx = Math.max(rx, i);
						ry = Math.max(ry, j);
					}
				}
				if(cnt == now.size) break;
			}
			
			int h = rx - lx;
			int w  = ry - ly;
			
			// 저 도형 & tmpB랑 비교해서 맨 0부터 쭉 비교
			boolean flag = false;
			for(int j = 1; j <= N - w; j++) {
				for(int i = 1; i <= N - h; i++) {
					// 비교하기 (x가 먼저 커져야함)
					flag = true;
					for(int x = 0; x <= h; x++) {
						for(int y = 0; y<= w; y++) {
							if(tmpB[i+x][j+y] != 0 && board[lx+x][ly+y] == now.idx) {
								flag = false;
							}
						}
						if(!flag) break;
					}
					
					// 불가능하면 다음 장소 (안되면 굳이 안옮김)
					if(!flag) continue;
					
					// 가능하면 그좌표부터 입력
					for(int x = 0; x <= h; x++) {
						for(int y = 0; y<= w; y++) {
							if(board[lx+x][ly+y] == now.idx) tmpB[i+x][j+y] = now.idx;
						}
					}
					break;
				}
				if(flag) break;
			}
		}
		board = tmpB;
	}

  // 3. 결과 기록
	public static long getResult() {
		List<Set<Integer>> list = new ArrayList<>();
		for(int i = 0; i <= Q; i++) {
			list.add(new HashSet<>());
		}
		
		boolean[][] visited = new boolean[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				// 비거나 이미 돌았으면 넘어감
				if(board[i][j] == 0 || visited[i][j]) continue;
				
				// 뭉탱이 방문
				Queue<Point> pq = new LinkedList<>();
				visited[i][j] = true;
				pq.offer(new Point(i, j));
				while(!pq.isEmpty()) {
					Point now = pq.poll();
					
					// 상하좌우 확인
					for(int k = 0; k < 4; k++) {
						int nx = now.x + dx[k];
						int ny = now.y + dy[k];
						if(checkArrange(nx, ny) && !visited[nx][ny]) {
							if(board[nx][ny] == board[i][j]) {
								pq.add(new Point(nx, ny));
								visited[nx][ny] = true;
							} else if(board[nx][ny] != 0 && board[nx][ny] != board[i][j]) {
								list.get(board[nx][ny]).add(board[i][j]);
							}
						}
					}
				}			
			}
		}
		
		// 정답 찾기
		long result = 0;
		for(int i = 1; i<= Q; i++) {
			for(Integer num : list.get(i)) {
				result += size[num] * size[i];
				list.get(num).remove(i);
			}
		}
		return result;
	}

	public static boolean checkArrange(int x, int y) {
		return 1 <= x && x <= N && 1 <= y && y <= N;
	}
	
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Info {
		int idx;
		int size;
		
		public Info(int idx, int size) {
			this.idx = idx;
			this.size = size;
		}
		
		public int getIdx() {
			return this.idx;
		}
		
		public int getSize() {
			return this.size;
		}
	}
}
