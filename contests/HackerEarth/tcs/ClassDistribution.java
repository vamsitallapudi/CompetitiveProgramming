import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class ClassDistribution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim()); // no. of test cases
        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            String[] capacityStr = br.readLine().split(" ");
            int[] capacity = new int[K];
            for (int j = 0; j < capacity.length; j++) {
                capacity[j] = Integer.parseInt(capacityStr[j]);
            }
            String[] preference = new String[N];
            for (int j = 0; j < preference.length; j++) {
                preference[j] = br.readLine();
            }
            String output = solve(N, K, capacity, preference);
            System.out.println(output);

        }
        wr.close();
        br.close();
    }

    public static List<Integer> getListFromScanner(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    static String solve(int N, int K, int[] capacity, String[] preference) {
        int totalCapacity = 0;
        for (int i = 0; i < capacity.length; i++) {
            totalCapacity += capacity[i];
        }
        // Edge Case
        if (totalCapacity < N) {
            return "NO";
        }

        // split pref string

        String result = "";

        return result;
    }

}
