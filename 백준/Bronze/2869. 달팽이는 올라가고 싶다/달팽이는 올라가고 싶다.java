import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        double days = (double) (v - b) /(a-b);
        System.out.println((int)Math.ceil(days));
    }
}
