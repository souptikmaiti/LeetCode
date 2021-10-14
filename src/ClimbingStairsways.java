public class ClimbingStairsways {

    public static void main(String[] args) {
        int n = 7;
        int[] dp = new int[n + 1];

        for (int i = n; i>=0; i--) {

            if (i == n) dp[i] = 0;
            else if (i == n-1) dp[i] = 1;
            else if (i == n-2) dp[i] = 2;
            else
                dp[i] = dp[i + 1] + dp[i + 2];


        }
        System.out.print( dp[0] );
    }
}
