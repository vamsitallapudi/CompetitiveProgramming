import java.util.*;

public class MaximumProduction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int d, x, y, z;
        while (t-- > 0) {
            List<String> myList = Arrays.asList(sc.nextLine().split(" "));
            d = Integer.parseInt(myList.get(0));
            x = Integer.parseInt(myList.get(1));
            y = Integer.parseInt(myList.get(2));
            z = Integer.parseInt(myList.get(3));
            // check if d * y + z > x *7
            System.out.println(Math.max(((d * y) + (7 - z)), x * 7));
        }
        sc.close();
    }
}
