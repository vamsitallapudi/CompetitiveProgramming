
import java.util.Scanner;

public class WordCapitalization {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            String sol = s.substring(0,1).toUpperCase() + s.substring(1);
            System.out.println(sol);
        }      
    }
}
