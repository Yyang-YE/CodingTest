import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] std = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            //std1
            if(i % 5 == 0 && answers[i] == 1) std[0]++;
            else if (i % 5 == 1 && answers[i] == 2) std[0]++;
            else if (i % 5 == 2 && answers[i] == 3) std[0]++;
            else if (i % 5 == 3 && answers[i] == 4) std[0]++;
            else if (i % 5 == 4 && answers[i] == 5) std[0]++;

            //std2
            if(i % 2 == 0 && answers[i] == 2) std[1]++;
            else if (i % 8 == 1 && answers[i] == 1) std[1]++;
            else if (i % 8 == 3 && answers[i] == 3) std[1]++;
            else if (i % 8 == 5 && answers[i] == 4) std[1]++;
            else if (i % 8 == 7 && answers[i] == 5) std[1]++;

            //std3
            if((i/2) % 5 == 0 && answers[i] == 3) std[2]++;
            else if ((i/2) % 5 == 1 && answers[i] == 1) std[2]++;
            else if ((i/2) % 5 == 2 && answers[i] == 2) std[2]++;
            else if ((i/2) % 5 == 3 && answers[i] == 4) std[2]++;
            else if ((i/2) % 5 == 4 && answers[i] == 5) std[2]++;
        }

        int max = Math.max(std[0], Math.max(std[1], std[2]));

        for (int i = 0; i < 3; i++) {
            if(std[i] == max) {
                result.add(i+1);
            }
        }
        return result;

    }
}