import java.util.Scanner;

public class EvenOdds {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            long n = sc.nextLong();
            long k = sc.nextLong();
            
            long oddCount = (n + 1) / 2;
            
            if (k <= oddCount) {
                // k-th position is in odd section
                System.out.println(2 * k - 1);
            } else {
                // k-th position is in even section
                long posInEven = k - oddCount;
                System.out.println(2 * posInEven);
            }

        }
    }
}
