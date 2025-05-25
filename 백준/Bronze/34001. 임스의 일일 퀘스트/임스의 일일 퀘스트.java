import java.io.*;

public class Main {
	static int level;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		level = Integer.parseInt(br.readLine());
		int[][] river = new int[][]{{200, 210, 220}, {210, 220, 225}, {220, 225, 230}, {225, 230, 235}, {230, 235, 245}, {235, 245, 250}};
		int[][] grandis = new int[][]{{260, 265, 270}, {265, 270, 275}, {270, 275, 280}, {275, 280, 285}, {280, 285, 290}, {285, 290, 295}, {290, 295, 300}};

		calculate(river);
		bw.write("\n");
		calculate(grandis);

		br.close();
		bw.close();
	}

	public static void calculate(int[][] info) throws IOException {
        for (int[] i : info) {
            if (i[2] <= level) {
                bw.write("100 ");
            } else if (i[1] <= level) {
                bw.write("300 ");
            } else if (i[0] <= level) {
                bw.write("500 ");
            } else {
                bw.write("0 ");
            }
        }
	}
}