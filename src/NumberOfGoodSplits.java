import java.util.*;

class SortIntegersByPowerValue {

    public static Map<Integer,Integer> dp = new HashMap<>();  // array not taken as upper limit can explode due to 3*x + 1

    public static void main(String[] args) {
        int lo = 118,  hi = 974, k = 825;
        ArrayList<Integer[]> ar = new ArrayList<>();
        int ans = 0;
        for (int i = lo; i<=hi; i++) {
            ar.add(new Integer[]{i, getPower(i)} );
        }

        Collections.sort(ar, (list1, list2) -> {
            if (list1[1] > list2[1])
                return 1;
            else if (list1[1] < list2[1])
                return -1;
            else
                return (list1[0] > list2[0] ? 1 : -1);
        });

        for (int i = 0; i<ar.size(); i++)
            if (i == k-1)
                ans = ar.get(i)[0];


        System.out.print( ans );
    }


    public static int getPower(int n) {
        if (dp.containsKey(n)) return dp.get(n);

        if (n == 1)  {dp.put(n,0); return 0;}
        if (n == 2)  {dp.put(n,1); return 1;}


        int step = 1;
        if (n % 2 == 0)
            step += getPower(n / 2);
        else
            step += getPower( (3*n) + 1);

        dp.put(n,step);
        return step;
    }

}
