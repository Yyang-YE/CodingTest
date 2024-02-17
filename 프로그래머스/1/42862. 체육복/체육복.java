import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostL = new ArrayList<Integer>();
        List<Integer> reserveL = new ArrayList<Integer>();
        List<Integer> temp = new ArrayList<Integer>();

        for(int l : lost) lostL.add(l);
        for(int r : reserve) reserveL.add(r);

        Collections.sort(lostL);
        Collections.sort(reserveL);

        for (int i = 0; i < lostL.size(); i++) {
            for (int j = 0; j < reserveL.size(); j++) {
                if(lostL.get(i) == reserveL.get(j)) {
                    temp.add(lostL.get(i));
                    lostL.set(i, -1);
                    reserveL.set(j, -1);
                    break;
                }
            }
        }

        for (int i = 0; i < lostL.size(); i++) {
            for (int j = 0; j < reserveL.size(); j++) {
                if(lostL.get(i) - 1 == reserveL.get(j) || lostL.get(i) + 1 == reserveL.get(j)) {
                    temp.add(lostL.get(i));
                    reserveL.set(j, -1);
                    break;
                }
            }
        }
        return n - lost.length + temp.size();
    }
}