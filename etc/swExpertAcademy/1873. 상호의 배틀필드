import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            sb.append("#").append(i).append(" ");
            int H = sc.nextInt();
            int W = sc.nextInt();
            sc.nextLine();

            String[][] map = new String[H][W];
            Coord curPlace = new Coord(); // 현재 포차의 위치 관리

            // map 입력받기
            for (int j = 0; j < H; j++) {
                String[] row = sc.nextLine().split("");
                for (int k = 0; k < W; k++) {
                    // 포차 시작 위치 확인 및 업데이트
                    if(row[k].equals("^") || row[k].equals("v") || row[k].equals("<") || row[k].equals(">")) {
                        curPlace = new Coord(j, k);
                    }
                    map[j][k] = row[k];
                }
            }

            // 명령 수
            int N = Integer.parseInt(sc.nextLine());
            String[] command = sc.nextLine().split("");
            for (String c : command) {
                // 가독성을 위해 현재 포차 위치 변수화
                int x = curPlace.x;
                int y = curPlace.y;

                switch (c) {
                    case "U":
                        if(curPlace.x - 1 >= 0 && map[x - 1][y].equals(".")) { // 위쪽이 평지이면
                            map[x][y] = "."; // 현 위치 평지로 전환
                            curPlace.x = x-1; // 위로 이동
                        }
                        map[curPlace.x][curPlace.y] = "^"; // 포차 방향 조정
                        break;
                    case "D":
                        if(curPlace.x + 1 < H && map[x + 1][y].equals(".")) { // 아래쪽이 평지이면
                            map[x][y] = "."; // 현 위치 평지로 전환
                            curPlace.x = x + 1; // 아래로 이동
                        }
                        map[curPlace.x][curPlace.y] = "v"; // 포차 방향 조정
                        break;
                    case "L":
                        if(curPlace.y - 1 >= 0 && map[x][y - 1].equals(".")) { // 왼쪽이 평지이면
                            map[x][y] = "."; // 현 위치 평지로 전환
                            curPlace.y = y - 1; // 왼쪽으로 이동
                        }
                        map[curPlace.x][curPlace.y] = "<"; // 포차 방향 조정
                        break;
                    case "R":
                        if(curPlace.y + 1 < W && map[x][y + 1].equals(".")) { // 오른쪽이 평지이면
                            map[x][y] = "."; // 현 위치 평지로 전환
                            curPlace.y = y + 1; // 오른쪽으로 이동
                        }
                        map[curPlace.x][curPlace.y] = ">"; // 포차 방향 조정
                        break;
                    case "S":
                        boolean isShooting = true;
                        Coord canon = new Coord(x, y);

                        while(isShooting) {
                            // 현재 포탄 위치 계산
                            switch (map[x][y]) {
                                case "^":
                                    if(canon.x - 1 >= 0) canon.x -= 1;
                                    else isShooting = false; // 포탄이 벗어남
                                    break;
                                case "v":
                                    if(canon.x + 1 < H) canon.x += 1;
                                    else isShooting = false; // 포탄이 벗어남
                                    break;
                                case "<":
                                    if(canon.y - 1 >= 0) canon.y -= 1;
                                    else isShooting = false; // 포탄이 벗어남
                                    break;
                                case ">":
                                    if(canon.y + 1 < W) canon.y += 1;
                                    else isShooting = false; // 포탄이 벗어남
                                    break;
                            }

                            if(map[canon.x][canon.y].equals("*")) { // 벽돌벽을 만남
                                map[canon.x][canon.y] = "."; // 벽 파괴
                                isShooting = false;
                            } else if(map[canon.x][canon.y].equals("#")) { // 강철벽을 만남
                                isShooting = false; // 포탄만 파괴
                            }
                        }
                        break;
                }
            }

            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    sb.append(map[j][k]);
                }
                if(j != H - 1) sb.append("\n");
            }
            if(i != T) sb.append("\n");
        }
        System.out.println(sb);
    }
    public static class Coord {
        int x;
        int y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Coord() { }
    }
}
