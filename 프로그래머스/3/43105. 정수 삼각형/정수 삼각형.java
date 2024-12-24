class Solution {
    public int solution(int[][] triangle) {
        for (int i = 0; i < triangle.length - 1; i++) {
            int[] temp = getMaxArray(triangle[i], triangle[i+1]);
            triangle[i + 1] = temp;
        }
        
        int[] resultArray = triangle[triangle.length - 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < resultArray.length; i++) {
            max = Math.max(max, resultArray[i]);
        }
        return max;    
    }
    
    private static int[] getMaxArray(int[] upper, int[] lower) {
        for (int i = 0; i < lower.length; i++) {
            if(i == 0) {
                lower[i] += upper[0];
            } else if(i == lower.length - 1) {
                lower[i] += upper[i - 1];
            } else {
                lower[i] += Math.max(upper[i], upper[i-1]);
            }
        }
        return lower;
    }
}