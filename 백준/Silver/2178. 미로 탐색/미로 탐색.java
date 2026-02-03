import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 미로탐색
 */
public class Main {
//    public static class Node {
//        private char val;
//        private boolean visited;
//        private int level;
//
//        public Node(char val) {
//            this.val = val;
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        Node[][] nodes = new Node[N + 1][M + 1];
//
//        for (int i = 1; i <= N; i++) {
//            char[] index = br.readLine().toCharArray();
//            for (int j = 1; j <= M; j++) {
//                nodes[i][j] = new Node(index[j - 1]);
//            }
//        }
//
//        Deque<int[]> queue = new ArrayDeque<>();
//        queue.addFirst(new int[]{1, 1});
//        nodes[1][1].level = 1;
//
//        while (!queue.isEmpty()) {
//            int[] nodePositions = queue.removeFirst();
//            int a = nodePositions[0];
//            int b = nodePositions[1];
//
//            nodes[a][b].visited = true;
//            if (a == N && b == M) {
//                break;
//            }
//
//            char val;
//            if (a > 1 && !nodes[a - 1][b].visited) {
//                val = nodes[a - 1][b].val;
//                if (val == '1') {
//                    nodes[a - 1][b].level = nodes[a][b].level + 1;
//                    queue.addLast(new int[]{a - 1, b});
//                }
//            }
//            if (a < N && !nodes[a + 1][b].visited) {
//                val = nodes[a + 1][b].val;
//                if (val == '1') {
//                    nodes[a + 1][b].level = nodes[a][b].level + 1;
//                    queue.addLast(new int[]{a + 1, b});
//                }
//            }
//            if (b > 1 && !nodes[a][b-1].visited) {
//                val = nodes[a][b-1].val;
//                if (val == '1') {
//                    nodes[a][b-1].level = nodes[a][b].level + 1;
//                    queue.addLast(new int[]{a, b - 1});
//                }
//            }
//            if (b < M && !nodes[a][b+1].visited) {
//                val = nodes[a][b+1].val;
//                if (val == '1') {
//                    nodes[a][b+1].level = nodes[a][b].level + 1;
//                    queue.addLast(new int[]{a, b + 1});
//                }
//            }
//
//        }
//        System.out.println(nodes[N][M].level);
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] nodes = new char[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            char[] index = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                nodes[i][j] = index[j-1];
            }
        }

        boolean[][] visited = new boolean[N+1][M+1];
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] level = new int[N+1][M+1];
        queue.addFirst(new int[]{1, 1});
        level[1][1] = 1;
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            int[] nodePositions = queue.removeFirst();
            int a = nodePositions[0];
            int b = nodePositions[1];

            if(a == N && b == M) {
                break;
            }

            char val;
            if(a > 1 && !visited[a-1][b]) {
                val = nodes[a - 1][b];
                if(val == '1') {
                    level[a-1][b] = level[a][b] + 1;
                    visited[a-1][b] = true;
                    queue.addLast(new int[]{a - 1, b});
                }
            }
            if(a < N && !visited[a+1][b]) {
                val = nodes[a + 1][b];
                if(val == '1') {
                    level[a+1][b] = level[a][b] + 1;
                    visited[a+1][b] = true;
                    queue.addLast(new int[]{a + 1, b});
                }
            }
            if(b > 1 && !visited[a][b-1]) {
                val = nodes[a][b - 1];
                if(val == '1') {
                    level[a][b-1] = level[a][b] + 1;
                    visited[a][b-1] = true;
                    queue.addLast(new int[]{a, b - 1});
                }
            }
            if(b < M && !visited[a][b+1]) {
                val = nodes[a][b + 1];
                if(val == '1') {
                    level[a][b+1] = level[a][b] + 1;
                    visited[a][b+1] = true;
                    queue.addLast(new int[]{a, b + 1});
                }
            }

        }
        System.out.println(level[N][M]);
    }
}
