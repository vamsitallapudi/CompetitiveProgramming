
import java.util.Scanner;


public class NearlyLuckyNumber {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            long count = s.chars().filter(c -> c == '4' || c =='7').count();
            if(count == 4l || count == 7l) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }        
    }
}
