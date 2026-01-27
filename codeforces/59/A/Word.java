
import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String w = sc.nextLine();
            int charLength = w.length();
            long upperCase = w.chars().filter(Character::isUpperCase).count();
            if(upperCase > charLength/2) {
                 System.out.println(w.toUpperCase());
            } else {
                System.out.println(w.toLowerCase());
            }
        }
    }
}
