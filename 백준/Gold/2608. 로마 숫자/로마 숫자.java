import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String rom1 = br.readLine();
        String rom2 = br.readLine();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int arabia = romaToInt(rom1) + romaToInt(rom2);
        sb.append(arabia).append("\n").append(intToRoma(arabia));
        System.out.println(sb);
    }

    public static int romaToInt(String rom) {
        char[] arr = rom.toCharArray();

        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i+1 < arr.length && arr[i] == 'I') {
                if(arr[i+1] == 'V') {
                    total += 4;
                    i++;
                } else if(arr[i+1] == 'X') {
                    total += 9;
                    i++;
                } else {
                    total += 1;
                }
            } else if(i+1 < arr.length && arr[i] == 'X') {
                if(arr[i+1] == 'L') {
                    total += 40;
                    i++;
                } else if(arr[i+1] == 'C') {
                    total += 90;
                    i++;
                } else {
                    total += 10;
                }
            } else if(i+1 < arr.length && arr[i] == 'C') {
                if(arr[i+1] == 'D') {
                    total += 400;
                    i++;
                } else if(arr[i+1] == 'M') {
                    total += 900;
                    i++;
                } else {
                    total += 100;
                }
            } else {
                total += map.get(arr[i]);
            }
        }
        return total;
    }

    public static String intToRoma(int num) {
        StringBuilder res = new StringBuilder();
        if(num >= 1000) { // 1000번대
            int n = num / 1000;
            for (int i = 0; i < n; i++) {
                res.append("M");
            }
            num %= 1000;
        }

        if(num >= 100) {
            int n = num / 100;
            if(n == 9) {
                res.append("CM");
            } else if(n == 4) {
                res.append("CD");
            } else {
                if(n >= 5) {
                    res.append("D");
                    n -= 5;
                }
                for (int i = 0; i < n; i++) {
                    res.append("C");
                }
            }
            num %= 100;
        }

        if(num >= 10) {
            int n = num / 10;
            if(n == 9) {
                res.append("XC");
            } else if(n == 4) {
                res.append("XL");
            } else {
                if(n >= 5) {
                    res.append("L");
                    n -= 5;
                }
                for (int i = 0; i < n; i++) {
                    res.append("X");
                }
            }
            num %= 10;
        }

        if(num >= 1) {
            if(num == 9) {
                res.append("IX");
            } else if(num == 4) {
                res.append("IV");
            } else {
                if(num >= 5) {
                    res.append("V");
                    num -= 5;
                }
                for (int i = 0; i < num; i++) {
                    res.append("I");
                }
            }
        }
        return res.toString();
    }
}
