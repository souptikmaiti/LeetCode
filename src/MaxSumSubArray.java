public class MaxSumSubArray {

    public static void main(String[] args) {

        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        int rollingSum = 0;

        int result = Integer.MIN_VALUE;
        /* Kadane 's logic
            if rollingSum is -ve , we start new seq from the current elem
        */
        for (int i =0; i<nums.length; i++) {
            if (rollingSum >= 0)
                rollingSum += nums[i];
            else
                rollingSum = nums[i];
            result = Math.max(result, rollingSum);
        }

        System.out.print( result );
    }
}
