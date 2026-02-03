import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            String leftChildVal = st.nextToken();
            String rightChildVal = st.nextToken();
            Node node;
            if (nodeMap.containsKey(value)) {
                node = nodeMap.get(value);
            } else {
                node = new Node(value);
                nodeMap.put(value, node);
            }
            Node leftChildNode;
            if (!leftChildVal.equals(".")) {
                if (nodeMap.containsKey(leftChildVal)) {
                    leftChildNode = nodeMap.get(leftChildVal);
                } else {
                    leftChildNode = new Node(leftChildVal);
                    nodeMap.put(leftChildVal, leftChildNode);
                }
                node.left = leftChildNode;
            }
            Node rightChildNode;
            if (!rightChildVal.equals(".")) {
                if (nodeMap.containsKey(rightChildVal)) {
                    rightChildNode = nodeMap.get(rightChildVal);
                } else {
                    rightChildNode = new Node(rightChildVal);
                    nodeMap.put(rightChildVal, rightChildNode);
                }
                node.right = rightChildNode;
            }
        }
        Node rootNode = nodeMap.get("A");
        // 전위 순회
        preOrder(rootNode);
        result.append("\n");

        // 중위 순회
        inOrder(rootNode);
        result.append("\n");

        // 후위 순회
        postOrder(rootNode);
        System.out.println(result);

    }

    private static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        result.append(node.value);
    }

    private static void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        result.append(node.value);
        inOrder(node.right);
    }

    private static void preOrder(Node node) {
        if(node == null) return;
        result.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }
}