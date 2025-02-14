import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree[i] = new Node(st.nextToken(), st.nextToken(), st.nextToken());
        }
        //노드를 ABC 순으로 정렬
        Arrays.sort(tree, Comparator.comparing(n -> n.parent));

        preorder(tree[0]);
        sb.append("\n");
        inorder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);

        System.out.println(sb);
    }

    // 전위 순회 (중->좌->우)
    private static void preorder(Node node) {
        // 자신 기록
        sb.append(node.parent);
        // 왼쪽 자식이 있다면 왼쪽 방문
        if(!node.leftChild.equals(".")) {
            preorder(tree[node.leftChild.charAt(0) - 65]);
        }
        // 오른쪽 자식이 있다면 오른쪽 방문
        if(!node.rightChild.equals(".")) {
            preorder(tree[node.rightChild.charAt(0) - 65]);
        }
    }

    // 중위 순회 (좌->중->우)
    private static void inorder(Node node) {
        // 왼쪽 자식이 있다면 왼쪽 방문
        if(!node.leftChild.equals(".")) {
            inorder(tree[node.leftChild.charAt(0) - 65]);
        }
        // 자신 기록
        sb.append(node.parent);
        // 오른쪽 자식이 있다면 오른쪽 방문
        if(!node.rightChild.equals(".")) {
            inorder(tree[node.rightChild.charAt(0) - 65]);
        }
    }

    // 후위 순회 (좌->우->중)
    private static void postorder(Node node) {
        // 왼쪽 자식이 있다면 왼쪽 방문
        if(!node.leftChild.equals(".")) {
            postorder(tree[node.leftChild.charAt(0) - 65]);
        }
        // 오른쪽 자식이 있다면 오른쪽 방문
        if(!node.rightChild.equals(".")) {
            postorder(tree[node.rightChild.charAt(0) - 65]);
        }
        // 자신 기록
        sb.append(node.parent);
    }

    public static class Node {
        String parent;
        String leftChild;
        String rightChild;

        public Node(String parent, String leftChild, String rightChild) {
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}
