import java.util.HashMap;
import java.util.Map;

public class TwoEggsDrop {

    static Map<String,Integer> dp = new HashMap<>();
    public static void main(String[] args) {
        int n = 100;
        System.out.print( attempts(n, 2));
    }

    static int attempts(int n, int e) {
        String key = n + "_" + e;
        if (dp.containsKey(key)) return dp.get(key);

        if (e == 1) {dp.put(key, n); return n;}
        if (n == 1 || n == 0) {dp.put(key, n); return n;}

        int count = Integer.MAX_VALUE;
        for (int f = 1; f<=n; f++) { // f is the threshold floor
            int unBroken =  1 + attempts(n-f, e);
            int broken = 1 + attempts(f-1, e-1);

            count = Math.min(count, Math.max(unBroken, broken));
        }
        dp.put(key, count);
        return count;
    }
}
