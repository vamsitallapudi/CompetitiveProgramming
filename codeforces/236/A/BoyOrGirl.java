
import java.util.Scanner;

public class BoyOrGirl {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            long ans = s.chars().distinct().count();
            if(ans %2 ==0) {
                System.out.println("CHAT WITH HER!");
            } else {
                System.out.println("IGNORE HIM!");
            }
        }
    }
}
