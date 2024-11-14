import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Point> points = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            points.add(new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }

        List<Point> sortedPoints = points.stream().sorted(Comparator.comparing(Point::getY)
            .thenComparing(Point::getX))
            .collect(Collectors.toList());

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(sortedPoints.get(i).getX()));
            bw.write(" ");
            bw.write(String.valueOf(sortedPoints.get(i).getY()));
            if(i < N - 1) bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
}