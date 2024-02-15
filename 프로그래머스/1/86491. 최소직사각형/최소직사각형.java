class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0, maxHeight = 0;

        for(int[] size: sizes) {
            if(Math.max(size[0], size[1]) == size[0]) {
                if(maxWidth < size[0]) maxWidth = size[0];
                if(maxHeight < size[1]) maxHeight = size[1];
            } else {
                if(maxWidth < size[1]) maxWidth = size[1];
                if(maxHeight < size[0]) maxHeight = size[0];
            }
        }
        return maxWidth * maxHeight;
    }
}