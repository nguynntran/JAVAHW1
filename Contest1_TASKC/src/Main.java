import java.io.*;
import java.util.*;

public class Main {
    static int[] Pi(String p) {
        int m = p.length();
        int[] pi = new int[m];
        int k = 0;
        for (int i = 1; i < m; i++) {
            while (k > 0 && p.charAt(k) != p.charAt(i)) {
                k = pi[k - 1];
            }
            if (p.charAt(k) == p.charAt(i)) {
                k++;
            }
            pi[i] = k;
        }
        return pi;
    }

    static List<Integer> kmp(String p, String t) {
        List<Integer> res = new ArrayList<>();
        int m = p.length(), n = t.length();
        if (m == 0 || m > n) return res;
        int[] pi = Pi(p);
        int q = 0;
        for (int i = 0; i < n; i++) {
            while (q > 0 && p.charAt(q) != t.charAt(i)) {
                q = pi[q - 1];
            }
            if (p.charAt(q) == t.charAt(i)) {
                q++;
            }
            if (q == m) {
                res.add(i - m + 1);
                q = pi[q - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pattern = br.readLine();
        String text = br.readLine();

        List<Integer> occ = kmp(pattern, text);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < occ.size(); i++) {
            if (i > 0) out.append(' ');
            out.append(occ.get(i));
        }
        System.out.println(out.toString());
    }
}