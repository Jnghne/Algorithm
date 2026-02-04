import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static boolean[][] visited;
    private static final List<Integer> homeCounts = new ArrayList<>();
    private static int N;
    private static char[][] map;
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int position = 0; position < N*N; position++) {
            int x = position / N;
            int y = position % N;
            if(visited[x][y]) {
                continue;
            }

            visited[x][y] = true;
            dfs(position);
            if(count!=0) {
                homeCounts.add(count);
            }
            count=0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(homeCounts.size()).append("\n");

        Collections.sort(homeCounts);
        for (Integer homeCount : homeCounts) {
            sb.append(homeCount).append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int position) {
        int x = position / N;
        int y = position % N;

        if(map[x][y] == '0') {
            return;
        }

        count++;

        if(x < N-1 && !visited[x+1][y] && map[x+1][y] == '1') {
            visited[x+1][y] = true;
            dfs((x+1)*N + y);
        }
        if(x > 0 && !visited[x-1][y]  && map[x-1][y] == '1') {
            visited[x-1][y] = true;
            dfs((x-1)*N + y);
        }
        if(y < N-1 && !visited[x][y+1] && map[x][y+1] == '1') {
            visited[x][y+1] = true;
            dfs(x*N + (y + 1));
        }
        if(y > 0 && !visited[x][y-1] && map[x][y-1] == '1') {
            visited[x][y-1] = true;
            dfs(x*N + (y - 1));
        }
    }
}
