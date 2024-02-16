class Solution {
    public String solution(int a, int b) {
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int days = 0;

        for (int i = 1; i < a; i++) {
            if(i==1 || i==3 || i==5 || i ==7 || i==8 || i==10 || i==12) {
                days += 31;
            } else if (i==2) {
                days += 29;
            } else {
                days += 30;
            }
        }
        return day[(days+b-1) % 7];
    }
}