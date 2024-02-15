class Solution {
    public long solution(int price, int money, int count) {
        long need = money;
        
        for (int i = 0; i < count; i++) {
            need -= price * (i+1);
        }
    
        return (need > 0) ? 0 : need * (-1);
    }
}