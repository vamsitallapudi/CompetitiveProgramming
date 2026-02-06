
import java.util.Scanner;

public class Drinks {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int temp  = n;
            double allPercent = 0;
            while(temp-- > 0) {
                allPercent+=sc.nextDouble();
            }
            double ans= allPercent/n;
            System.out.println(ans);
        }
    }
}
