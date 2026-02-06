import java.util.Scanner;

public class LuckyDivision {
    public static void main(String[] args) {
        int[] arr = new int[] {
            4,7,
            44, 47, 74, 77,
            444, 447, 474, 477,
            744, 747, 774, 777
        };

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i : arr) {
            if(n%i == 0) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }
}
