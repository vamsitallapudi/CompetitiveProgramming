import java.util.Scanner;

public class Elephant {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int x = sc.nextInt();
            // int[] v = new int[] {5,4,3,2,1};
            // int ans = 0;
            // for (int i : v) {
            //     while(x>=i) {
            //         ans+=x/i;
            //         x%=i;
            //     }
            // } -> my solution
            int ans = (x+4)/5; // rounding off as ans will be 1 more than divisible by 5
            System.out.println(ans);
        }
    }
}
