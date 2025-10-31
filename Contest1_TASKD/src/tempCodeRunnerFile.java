import java.util.*;


public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       scanner.nextLine();

       Stack<Integer> sta = new Stack<>();
       Stack<Integer> maxsta = new Stack<>();

       for (int i = 0; i < n ; i++){
            String[] query = scanner.nextLine().split(" ");
            String operation = query[0];
            if (operation.equals("push")){
                int value = Integer.parseInt(query[1]);
                sta.push(value);
                if (maxsta.isEmpty() || value >= maxsta.peek()){
                    maxsta.push(value);
                }
            } else if (operation.equals("pop")){
                if (!sta.isEmpty()){
                    int poppedValue = sta.pop();
                    if (poppedValue == maxsta.peek()){
                        maxsta.pop();
                    }
                }
            } else if (operation.equals("max")){
                if (!maxsta.isEmpty()){
                    System.out.println(maxsta.peek());
                }
            }
       }

         scanner.close();
    }
}