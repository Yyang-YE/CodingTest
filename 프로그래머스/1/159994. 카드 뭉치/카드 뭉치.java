class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int a=0, b=0;

        for (int i = 0; i < goal.length; i++) {
            if(a< cards1.length) {
                if(goal[i].compareTo(cards1[a]) == 0) {
                    a++;
                    continue;
                }
            }
            if(b< cards2.length) {
                if(goal[i].compareTo(cards2[b]) == 0) {
                    b++;
                    continue;
                }
            }
            return "No";
        }
        return "Yes";
    }
}