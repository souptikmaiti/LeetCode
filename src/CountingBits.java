import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        Arrays.stream(countBits(5)).forEach(i -> System.out.print(i + " "));
    }
    public static int[] countBits(int n) {

        int[] ans = new int[n+1];
        int p = 0;
        for(int i = 1; i<=n; i++) {

            // if i == 2^k form

            if( (i & (i-1)) == 0)
                p = i;

            //dynamic part
            ans[i] = ans[i - p] + 1;

        }
        return ans;
    }

    /*static int findOnes(int k) {
        int count = 0;
        while(k>=2) {
            k -= Math.pow(2,  Math.floor(Math.log(k)/Math.log(2)));
            count ++;
        }

        if(k==1){
            count ++;
        }
        return count;
    }

     */
}
