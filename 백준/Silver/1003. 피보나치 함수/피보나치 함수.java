import java.io.*;

public class Main {
    static Count[] memory = new Count[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < memory.length; i++) {
            memory[i] = new Count();
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            if(!memory[n].isUpdated) {
                fibonacci(n);
            }

            bw.write(String.valueOf(memory[n].countZero));
            bw.write(" ");
            bw.write(String.valueOf(memory[n].countOne));
            if(i != T-1) bw.write("\n");
        }
        bw.flush();
    }

    static class Count {
        int countZero = 0;
        int countOne = 0;
        boolean isUpdated = false;
    }

    static Count fibonacci(int n) {
        if(memory[n].isUpdated) return memory[n];
        memory[n].isUpdated = true;
        if (n == 0) {
            memory[n].countZero++;
            return memory[0];
        } else if (n == 1) {
            memory[n].countOne++;
            return memory[1];
        } else {
            Count c1 = fibonacci(n-1);
            Count c2 = fibonacci(n-2);
            memory[n].countZero= c1.countZero + c2.countZero;
            memory[n].countOne= c1.countOne + c2.countOne;
        }
        return memory[n];
    }
}