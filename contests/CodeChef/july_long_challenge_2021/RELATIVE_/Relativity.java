import java.util.*;
import java.util.stream.Collectors;

public class Relativity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            List<Integer> myList = Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt)
                    .collect(Collectors.toList());
            System.out.println((myList.get(1) * myList.get(1)) / (2 * myList.get(0)));
        }
        sc.close();
    }
}
