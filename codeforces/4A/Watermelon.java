import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Watermelon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        // Read input
        int n = Integer.parseInt(br.readLine());
        
        
        // TODO: even 
        // Output
        if(n%2 == 0 && n>2) out.println("YES");
        else out.println("NO");
        out.close();
    }
}