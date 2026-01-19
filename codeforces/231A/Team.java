
import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int ans = 0;
        // Output
        while(n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if((a+b+c) >=2) ans++;
        }
        System.out.println(ans);
        sc.close();
    }
}
