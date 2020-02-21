import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Practice2d33 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> dq = new ArrayDeque<>();
        String line = br.readLine();
        while (line != null) {
            dq.push(line);
            line = br.readLine();
        }
        
        while (!dq.isEmpty()) {
            System.out.println(dq.pop());
        }
        
    }
}