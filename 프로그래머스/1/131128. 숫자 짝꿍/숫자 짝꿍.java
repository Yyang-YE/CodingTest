class Solution {
    public String solution(String X, String Y) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] Xcount = new int[10];
        int[] Ycount = new int[10];

        for (int i = 0; i < Math.max(X.length(), Y.length()); i++) {
            if(i<X.length())
                Xcount[X.charAt(i) - '0']++;
            if(i<Y.length())
                Ycount[Y.charAt(i) - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            int cnt = Math.min(Xcount[i], Ycount[i]);
            while(cnt > 0) {
                stringBuilder.append(i);
                cnt--;
            }
        }

        if (stringBuilder.length() == 0) return "-1";
        else if (stringBuilder.charAt(0) == '0') return "0";
        return stringBuilder.toString();
    }
}