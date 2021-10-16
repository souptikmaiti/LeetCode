import java.util.HashMap;
import java.util.Map;

public class VowelsSequence {
    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
    static Map<String, Integer> dp = new HashMap<>();
    public static void main(String[] args) {

        int n = 33;
        int count = 0;
        for (int i = 0; i<5; i++) {
            count += calculate(vowels[i], n-1);
        }
        System.out.print(count);
    }

    public static int calculate(char c, int rem) {
        String key = c + "_" + rem;
        if (dp.containsKey(key)) return dp.get(key);
        //if (rem == 0) return dp.put(key, 5);
        if (rem == 1) {
            if (c == 'a') {dp.put(key, 5); return 5;};
            if (c == 'e') {dp.put(key, 4); return 4;};
            if (c == 'i') {dp.put(key, 3); return 3;};
            if (c == 'o') {dp.put(key, 2); return 2;};
            if (c == 'u') {dp.put(key, 1); return 1;};
        }

        int count = 0;
        int j = 0;
        if (c == 'a') j = 0;
        if (c == 'e') j = 1;
        if (c == 'i') j = 2;
        if (c == 'o') j = 3;
        if (c == 'u') j = 4;

        for (int k = j; k<5; k++) {
            count += calculate(vowels[k], rem - 1);
        }
        dp.put(key, count);
        return count;
    }

}
