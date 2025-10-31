import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> sta = new Stack<>();
        Stack<Integer> maxsta = new Stack<>();
        List<Integer> maxRes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String[] query = br.readLine().split(" ");
            String operation = query[0];
            
            if (operation.equals("push")) {
                int value = Integer.parseInt(query[1]);
                sta.push(value);
                
                
                if (maxsta.isEmpty() || value >= maxsta.peek()) {
                    maxsta.push(value);
                } else {
                    maxsta.push(maxsta.peek());
                }
            } else if (operation.equals("pop")) {
                if (!sta.isEmpty()) {
                    sta.pop();
                    maxsta.pop(); 
                }
            } else if (operation.equals("max")) {
                if (!maxsta.isEmpty()) {
                    maxRes.add(maxsta.peek());
                }
            }
        }
        
        for (int result : maxRes) {
            pw.println(result);
        }
        
        pw.flush();
        pw.close();
        br.close();
    }
}