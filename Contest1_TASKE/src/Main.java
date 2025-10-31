import java.io.*;

public class Main {
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        // Input highway endpoints A and B
        String[] highway = br.readLine().split(" ");
        Point A = new Point(Integer.parseInt(highway[0]), Integer.parseInt(highway[1]));
        Point B = new Point(Integer.parseInt(highway[2]), Integer.parseInt(highway[3]));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        

        for (int i = 0; i < n; i++){
            String[] river = br.readLine().split(" ");
            Point C = new Point(Integer.parseInt(river[0]), Integer.parseInt(river[1]));
            Point D = new Point(Integer.parseInt(river[2]), Integer.parseInt(river[3]));
            if (Intersect(A, B, C, D)){
                count++;
            }
        }

        pw.println(count);
        pw.flush();
        pw.close();
        br.close();

}
        static boolean Intersect (Point A, Point B, Point C, Point D){
            if (orient_method(A, B, C) != orient_method(A, B, D) && orient_method(C, D, A) != orient_method(C, D, B)){
                return true;
            }
            return false;
        }

        static int orient_method (Point p, Point q, Point r){
            int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
            if (val == 0) return 0; // collinear
            return (val > 0)? 1: 2; // clock or counterclock wise
        }
}