class Solution {
    static int N, M;
    static int[][] slock;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        // 전역변수화
        N = lock.length;
        M = key.length;
        slock = lock;
        
        // 키 만들기
        int[][][] keyList = new int[4][M][M];
        keyList[0] = key.clone();
        keyList[1] = rotate(keyList[0]);
        keyList[2] = rotate(keyList[1]);
        keyList[3] = rotate(keyList[2]);
        
        // 점검
        for(int i = 0; i < 4; i++) {
            answer = checkAnswer(keyList[i]);
            if(answer) break;
        }
        return answer;
    }
    
    public boolean checkAnswer(int[][] key) {        
        for(int i = 0; i < N+M-1; i++) {
            for(int j = 0; j < N+M-1; j++) {
                // KEY 설정
                int[][] bigKey = getKey(key, i, j);
                
                // lock 확인
                if(checkLock(bigKey)) return true;
            }
        }
        return false;
    }
    
    public boolean checkLock(int[][] bigKey) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(slock[i][j] + bigKey[i+M-1][j+M-1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int[][] getKey(int[][] key, int i, int j) {
        int[][] bigKey = new int[N+(M-1)*2][N+(M-1)*2];
        for(int k = 0; k < M; k++) {
            for(int l = 0; l < M; l++) {
                bigKey[i+k][j+l] = key[k][l];
            }
        }
        return bigKey;
    }
    
    public int[][] rotate (int[][] arr) {
        int[][] rotate = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                rotate[j][arr.length - i - 1] = arr[i][j];
            }
        }
        return rotate;
    }
}