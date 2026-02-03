import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static char[][] map;
    private static int R;
    private static int C;
    private static int MAX_MOVE = 0;
    private static HashMap<Character, Boolean> visited = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] mapY = br.readLine().toCharArray();
            map[i] = mapY;
            for (char c : mapY) {
                visited.put(c, false);
            }
        }
        dfs(0, 0);
        System.out.println(MAX_MOVE);
    }

    private static void dfs(int index, int moves) {
        int x = index / C;
        int y = index % C;
        moves++;
        visited.put(map[x][y], true);

        // x, y+1
        if(y < (C-1) && !visited.get(map[x][y+1])) {
            dfs((x * C) + (y + 1), moves);
        }


        // (+1, 0)
        if(x < (R - 1) && !visited.get(map[x+1][y])) {
            dfs((x + 1) * C + y, moves);
        }

        // (-1, 0)
        if(x >= 1 && !visited.get(map[x-1][y])) {
            dfs((x - 1) * C + y, moves);
        }
        // (0, -1)
        if(y >= 1 && !visited.get(map[x][y-1])) {
            dfs((x* C) + (y - 1), moves);
        }

        if(moves > MAX_MOVE) {
            MAX_MOVE = moves;
        }
        visited.put(map[x][y], false);
    }
}
