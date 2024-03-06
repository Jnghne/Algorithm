import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr, X);
    }

    private static void solution(int[] arr, int x) {
        for(int a : arr) {
            if(a<x) {
                System.out.print(a+" ");
            }
        }
    }
}