import java.util.Arrays;

public class DivisorGame {

    public static void main(String[] args) {
        int n = 4;
        Boolean[] stored = new Boolean[n+1];
        // turn = true if its Alice's turn
        boolean turn = true;
        solve(n, stored, turn);
        System.out.print( stored[n] );
    }

    static boolean solve(int n, Boolean[] ar, boolean turn) {
        if (ar[n] != null) return ar[n];

        if (n==1 && turn) return ar[n] = false;
        if (n==1 && !turn) return ar[n] = true;

        boolean b = false;
        for (int x = 1; x< n; x++) {
            if(n%x == 0) {
                b = b || solve( n-x, ar, !turn);
            }
        }
        return ar[n] = b;
    }
}
