import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        if (text.isBlank()) {
            System.out.print(0);
        } else {
            System.out.print(text.trim().split(" ").length);
        }
    }
}