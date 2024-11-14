import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Person> people = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            people.add(new Person(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }

        for (Person p : people) {
            long count = people.stream()
                .filter(other -> other.getHeight() > p.getHeight() && other.getWeight() > p.getWeight())
                .count();
            p.setRank((int) count + 1);
        }

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(people.get(i).getRank()));
            if(i < N - 1) bw.write(" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static class Person {
        private int weight;
        private int height;
        private int rank;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }
        public int getHeight() {
            return height;
        }
        public int getRank() {
            return rank;
        }
        public void setRank(int rank) {
            this.rank = rank;
        }
    }
}