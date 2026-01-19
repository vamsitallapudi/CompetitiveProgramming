
import java.util.Scanner;



public class NextRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;
        int[] arr = new int[n];
        for(int i = 0; i< n; i++) {
            int a = sc.nextInt();
            arr[i] = a;
        }
        for(int i : arr) {
            if(i == 0 || i<arr[k-1]) {
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }
}
