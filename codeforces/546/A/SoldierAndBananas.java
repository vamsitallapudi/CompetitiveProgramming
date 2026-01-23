import java.util.Scanner;

public class SoldierAndBananas {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int w = sc.nextInt();
            int moneyNeeded = (k*w *(w+1))/2;
            int ans = 0;
            if(n<moneyNeeded) {
                ans = moneyNeeded -n;
            }
            System.out.println(ans);
        }
    }    
}
