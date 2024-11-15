import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();

        long meanTotal = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers.add(num);
            meanTotal += num;
            if(min > num) min = num;
            if(max < num) max = num;
        }

        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());

        Map<Integer, Integer> frequencyMap = numbers.stream()
            .collect(Collectors.toMap(n -> n, n -> 1, Integer::sum));

        List<Integer> freqMaxList = new ArrayList<>();
        int freqMaxCount = 0;
        for (Map.Entry<Integer, Integer> m : frequencyMap.entrySet()) {
            if (m.getValue() > freqMaxCount) {
                freqMaxCount = m.getValue();
                freqMaxList.clear();
                freqMaxList.add(m.getKey());
            } else if (m.getValue() == freqMaxCount) {
                freqMaxList.add(m.getKey());
            }
        }

        freqMaxList = freqMaxList.stream().sorted().collect(Collectors.toList());

        // 산술 평균
        System.out.println(Math.round((double) meanTotal / N));
        // 중앙값
        System.out.println(sortedNumbers.get(N/2));
        // 최빈값
        System.out.println(freqMaxList.size() > 1 ? freqMaxList.get(1) : freqMaxList.get(0));
        // 범위
        System.out.println(max - min);
    }
}