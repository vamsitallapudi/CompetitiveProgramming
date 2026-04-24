
import java.util.Scanner;

public class Tram {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int curr = 0;
            int max = 0;
            while(n-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int stopAdd = b-a;
                curr +=stopAdd;
                max = Math.max(max, curr);
            }
            System.out.println(max);
        }
    }
}
