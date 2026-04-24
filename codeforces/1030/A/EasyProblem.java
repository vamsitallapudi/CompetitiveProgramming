
import java.util.Scanner;

public class EasyProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0) {
            int i = sc.nextInt();

            if(i == 1) {
                System.out.println("HARD");
                return;
            }
            
        }
        System.out.println("EASY");

    }
}
