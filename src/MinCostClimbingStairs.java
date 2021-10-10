import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        //input
        //[1,100,1,1,1,100,1,1,100,1]
        int[] cost = new int[10];
        cost[0] = 1;
        cost[1] = 100;
        cost[2] = 1;
        cost[3] = 1;
        cost[4] = 1;
        cost[5] = 100;
        cost[6] = 1;
        cost[7] = 1;
        cost[8] = 100;
        cost[9] = 1;

        int[] status = new int[cost.length + 1];
        Arrays.fill(status, -1);

        System.out.print( solve(cost.length, cost, status) );
    }

    static int solve(int n, int[] cost, int[] status) {

        if (status[n] != -1) return status[n];

        if (n == 0 || n==1) return status[n] = 0;

        return status[n] = Math.min( cost[n-1] + solve(n-1, cost, status), cost[n-2] + solve(n-2, cost, status));
    }
}
