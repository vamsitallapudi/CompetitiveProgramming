
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Prob996A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        // Read input
        int n = Integer.parseInt(br.readLine());
        
        // Your solution here
        int bills = 0;
        
        // TODO: Calculate minimum bills

        int[] denom = new int[] {100, 20, 10, 5, 1};
        for (int i : denom) {
            bills += n/i;
            n %= i;
        }
        // Output
        out.println(bills);
        out.close();
    }
}
