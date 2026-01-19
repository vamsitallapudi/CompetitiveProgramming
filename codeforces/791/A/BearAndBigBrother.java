
import java.util.Scanner;


public class BearAndBigBrother {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int limak = sc.nextInt();
            int bob = sc.nextInt();

            int ans = 0;
            while( limak <= bob) {
                limak*=3;
                bob*=2;
                ans++;
            }
            System.out.println(ans);
        }
    }
}
