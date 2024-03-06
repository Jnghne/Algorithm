import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0; // 17 * 8  // 136 + 3 + 21 // 160
        while (N-- > 0) {
            int num = sc.nextInt();
            if(num <= 1){
                continue;
            }
            if(isPrime(num)) {
                count ++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}