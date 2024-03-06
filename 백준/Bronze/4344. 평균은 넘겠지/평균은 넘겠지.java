import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while ( C -- > 0) {
            int N = sc.nextInt();
            int[] scores = new int[N];
            for(int i = 0; i <N; i++) {
                scores[i] = sc.nextInt();
            }
            int average = Arrays.stream(scores).sum() / scores.length;
            long countUpperAvg = Arrays.stream(scores).filter(s -> s > average).count();
            float result = (float) countUpperAvg / scores.length * 100;
            sb.append(String.format("%.3f%%", result)).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}