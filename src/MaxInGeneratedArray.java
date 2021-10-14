import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxInGeneratedArray {

    public static void main(String[] args) {
        int n = 7;
        int[] num = new int[n+1];

        int result = Integer.MIN_VALUE;

        for (int i = 0; i<=n; i++) {
            if (i ==0 || i==1)
                num[i] = i;

            else if (i % 2 == 0)
                num[i] = num[i/2];

            else if (i % 2 == 1)
                num[i] = num[(i-1)/2] + num[(i+1)/2];

            result = Math.max(result, num[i]);

        }
        System.out.print( result );
    }
}
