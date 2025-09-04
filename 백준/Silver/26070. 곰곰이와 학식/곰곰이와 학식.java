import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] gom = new int[3];
        for (int i = 0; i < 3; i++) {
            gom[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] coupon = new int[3];
        for (int i = 0; i < 3; i++) {
            coupon[i] = Integer.parseInt(st.nextToken());
        }

        long eatGom = 0;
        for (int t = 0; t < 3; t++) {
            for (int i = 0; i < 3; i++) {
                eatGom += Math.min(coupon[i], gom[i]);
                if(coupon[i] >= gom[i]) {
                    coupon[i] -= gom[i];
                    gom[i] = 0;
                } else {
                    gom[i] -= coupon[i];
                    coupon[i] = 0;
                }

                if(coupon[i] > 0) {
                    int next = coupon[i] / 3;
                    coupon[getNext(i)] += next;
                    coupon[i] %= 3;
                }
            }
        }
        System.out.println(eatGom);
    }

    private static int getNext(int i) {
        if(i == 0) return 1;
        if(i == 1) return 2;
        if(i == 2) return 0;
        return -1;
    }
}
