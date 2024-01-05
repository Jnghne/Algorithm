import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int pointer;
    public static int N;
    public static int K;
    public static ArrayList<Integer> li = new ArrayList<>();
    public static LinkedList<Integer> result = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pointer = K - 1;

        // 리스트 세팅
        for (int i = 0; i < N; i++) {
            li.add(i + 1);
        }

        sb.append("<");


        while (true) {
            result.add(li.get(pointer));
            sb.append(li.get(pointer)).append(", ");
            li.set(pointer, 0);

            // 끝났는지 확인
            if(result.size() == N){
                break;
            }

            next();
        }

        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");
        System.out.println(sb);
    }


    private static void next() {
        for(int i=1; i<=K; i++){
            while (true) {
                pointer++;
                if(pointer>=N) {
                    pointer = 0;
                }
                if(!li.get(pointer).equals(0)){
                    break;
                }
            }
        }
    }
}