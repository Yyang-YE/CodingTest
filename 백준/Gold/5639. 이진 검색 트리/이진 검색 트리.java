import java.io.*;

public class Main {
    static Node[] nodes = new Node[10000001];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rootNum = Integer.parseInt(br.readLine());
        nodes[rootNum] = new Node();

        while(true) {
            String s = br.readLine();
            if(s == null || s.equals("")) break;
            putNode(Integer.parseInt(s), rootNum);
        }

        postOrder(rootNum);

        br.close();
        bw.close();
    }

    private static void putNode(int num, int curNode) {
        if(curNode < num) { // 크면 오른쪽 저장
            if(nodes[curNode].rightChild == -1) { // 비어있으면 저장
                nodes[curNode].rightChild = num;
                nodes[num] = new Node();
            } else { // 차있으면 재비교
                putNode(num, nodes[curNode].rightChild);
            }
        } else {
            if(nodes[curNode].leftChild == -1) { // 비어있으면 저장
                nodes[curNode].leftChild = num;
                nodes[num] = new Node();
            } else { // 차있으면 재비교
                putNode(num, nodes[curNode].leftChild);
            }
        }
    }

    private static void postOrder(int curNode) throws IOException {
        if(nodes[curNode].leftChild != -1) {
            postOrder(nodes[curNode].leftChild);
        }
        if(nodes[curNode].rightChild != -1) {
            postOrder(nodes[curNode].rightChild);
        }
        bw.write(curNode + "\n");
    }

    public static class Node {
        int leftChild = -1;
        int rightChild = -1;
    }
}
