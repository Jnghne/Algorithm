import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS 특정 거리의 도시 찾기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken());  // 도로 개수
        int K = Integer.parseInt(st.nextToken()); // 최단 거리
        int X = Integer.parseInt(st.nextToken()); // 출발 도시

        // 맵 생성
        List<Integer>[] map = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        // 간선 연결
        for (int i = 1; i <= M; i++) {
            String[] lines = br.readLine().split(" ");
            int from = Integer.parseInt(lines[0]);
            int to = Integer.parseInt(lines[1]);
            map[from].add(to);
        }

        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(X);
        distance[1] = 0;
        visited[1] = true;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> adjs = map[node];
            for (Integer adj : adjs) {
                if(!visited[adj]) {
                    distance[adj] = distance[node] + 1;
                    visited[adj] = true;
                    queue.offer(adj);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N ; i++) {
            if(distance[i] == K) {
                sb.append(i);
                sb.append("\n");
            }
        }
        if(sb.isEmpty()) {
            sb.append("-1");
        }

        System.out.println(sb);

    }
}
