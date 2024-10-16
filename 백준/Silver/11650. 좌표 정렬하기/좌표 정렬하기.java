import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        List<Coord> coords = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();
            coords.add(new Coord(x, y));
        }

        List<Coord> result = coords.stream().sorted(Comparator.comparingInt((Coord c) -> c.x)
            .thenComparingInt(c -> c.y)).collect(Collectors.toList());

        for (Coord c : result) {
            System.out.println(c.x + " " + c.y);
        }
    }

    public static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}