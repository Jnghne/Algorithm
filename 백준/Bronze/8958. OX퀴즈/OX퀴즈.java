import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int oCnt = 0;
            int sum = 0;
            char[] charArray = sc.next().toCharArray();
            for (char ox : charArray) {
                if(ox == 'O') oCnt = oCnt+1;
                else oCnt = 0;
                sum = sum + oCnt;
            }
            result[i] = sum;
        }
        Arrays.stream(result).forEach(System.out::println);
    }
}