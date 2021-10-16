import java.util.HashMap;
import java.util.Map;

public class PartitionArrayForMaximumSum {

    static Map<String,Integer> dp = new HashMap<>();
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,1,5,7,3,6,1,9,9,3};
        int k = 4;

        int len = arr.length;
        int[] dp = new int[len + 1];

        dp[1] = arr[0];

        for (int i = 2; i<len+1; i++) {

            int ansSofar = Integer.MIN_VALUE;

            int groupMax = Integer.MIN_VALUE;
            for (int g = 1; g <= k; g++) {  // try all possible groups

                for (int j = i-1; j> i-1-g && j>=0; j--)   // find the group max
                    groupMax = Math.max(groupMax, arr[j]);

                if (i-g >= 0)
                    ansSofar = Math.max(ansSofar, groupMax * g + dp[i-g]);  // main dp step
            }

            dp[i] = ansSofar;
        }

        System.out.print( dp[len] );
    }
}
