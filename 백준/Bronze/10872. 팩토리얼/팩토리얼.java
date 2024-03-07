import java.util.Scanner;

public class Main {
    // 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 1;
        for (int i = 0; i < N; i++) {
            result = result * (N-i);
        }
        System.out.println(result);
    }
}