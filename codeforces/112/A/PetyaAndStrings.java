
import java.util.Scanner;


public class PetyaAndStrings {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int ans = s1.compareToIgnoreCase(s2);
            System.out.println(Integer.signum(ans));
        }
    }
}
