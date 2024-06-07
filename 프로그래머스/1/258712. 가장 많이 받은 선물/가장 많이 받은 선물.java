import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        List<Edge> edges = new ArrayList<>();

        //주고 받은 선물 수를 표로 나타 내기
        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            for (Edge edge : edges) {
                if (edge.giveFriend.equals(temp[0]) && edge.getFriend.equals(temp[1])) {
                    edge.amount += 1;
                }
            }
            edges.add(new Edge(temp[0], temp[1], 1));
        }

        //각 사람이 이번달에 받을 선물 개수를 계산하기!
        //초기화
        Map<String, Integer> getPresent = new HashMap<>();
        for (String friend : friends) {
            getPresent.put(friend, 0);
        }

        for (int i = 0; i < friends.length-1; i++) {
            for (int j = i+1; j < friends.length; j++) {
                //서로 주고 받은 것 계산
                int aGive = 0;
                int bGive = 0;
                int aGiftVal = 0;
                int bGiftVal = 0;
                for (Edge edge : edges) {
                    if (Objects.equals(friends[i], edge.giveFriend) && Objects.equals(friends[j], edge.getFriend)) {
                        aGive++;
                    }
                    if (Objects.equals(friends[j], edge.giveFriend) && Objects.equals(friends[i], edge.getFriend)) {
                        bGive++;
                    }
                    //선물 지수 계산
                    if (Objects.equals(friends[i], edge.giveFriend)) {
                        aGiftVal++;
                    } else if (Objects.equals(friends[i], edge.getFriend)) {
                        aGiftVal--;
                    }
                    if (Objects.equals(friends[j], edge.giveFriend)) {
                        bGiftVal++;
                    } else if (Objects.equals(friends[j], edge.getFriend)) {
                        bGiftVal--;
                    }
                }

                if (aGive > bGive) {
                    //a가 준 횟수가 더 많으면, a가 선물을 받음
                    int newValue = getPresent.get(friends[i]) + 1;
                    getPresent.put(friends[i], newValue);
                } else if (aGive < bGive) {
                    //b가 준 횟수가 더 많으면, b가 선물을 받음
                    int newValue = getPresent.get(friends[j]) + 1;
                    getPresent.put(friends[j], newValue);
                } else {
                    if (aGiftVal > bGiftVal) {
                        //a가 선물을 받음
                        int newValue = getPresent.get(friends[i]) + 1;
                        getPresent.put(friends[i], newValue);
                    } else if (aGiftVal < bGiftVal) {
                        //b가 선물을 받음
                        int newValue = getPresent.get(friends[j]) + 1;
                        getPresent.put(friends[j], newValue);
                    }

                }

            }
        }
        int maxVal  = 0;
        for (String s : getPresent.keySet()) {
            if(maxVal < getPresent.get(s)) {
                maxVal = getPresent.get(s);
            }
        }
        return maxVal;
    }

    static class Edge {
        String giveFriend;
        String getFriend;
        int amount;

        public Edge(String giveFriend, String getFriend, int amount) {
            this.giveFriend = giveFriend;
            this.getFriend = getFriend;
            this.amount = amount;
        }
    }
}