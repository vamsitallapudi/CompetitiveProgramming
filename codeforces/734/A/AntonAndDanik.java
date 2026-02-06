
import java.util.Scanner;

public class AntonAndDanik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String s = sc.next();

        long antonWins = s.chars().filter(c -> c == 'A').count();
        long danikWins = s.toCharArray().length - antonWins;

        if(danikWins > antonWins) {
            System.out.println("Danik");
        } else if(danikWins < antonWins) {
            System.out.println("Anton");
        } else {
            System.out.println("Friendship");
        }
    }
}
