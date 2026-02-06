
import java.util.Scanner;

public class Football {
    public static void main(String[] args) {
        char prev = 'a';
        int count =0;
        try (Scanner sc = new Scanner(System.in)) {
            String n = sc.nextLine();
            for(char c : n.toCharArray()) {
                if (c == prev) {
                    count++;
                    if(count >= 7) {
                        System.out.println("YES");
                        return;
                    }
                } else {
                    prev = c;
                    count = 1;
                }
            }
            System.out.println("NO");
        }
    }
}
