import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> stack = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            
            switch (st.nextToken()) {
                case "push":
                    int b = Integer.parseInt(st.nextToken());
                    stack.add(b);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(stack.get(stack.size() - 1));
                    stack.remove(stack.size() - 1);
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.get(stack.size() - 1));
                    break;
            }
        }
    }
}