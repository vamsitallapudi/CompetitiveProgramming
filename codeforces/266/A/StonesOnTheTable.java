import java.util.Scanner;

public class StonesOnTheTable {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            String s = sc.next();
            int ans = 0;
            for(int i = 0; i< s.length() -1;i++) {
                if(s.charAt(i) == s.charAt(i+1)) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
