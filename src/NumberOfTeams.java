import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfTeams {
    public static void main(String[] args) {

        int[] rating = new int[]{2, 5, 3, 4, 1};

        int count = 0;

        // fix middle index j

        int len = rating.length;

        for (int j = 1; j < len-1; j++) {

            int smallerBef = 0;
            int greaterAft = 0;

            int greaterBef = 0;
            int smallerAft = 0;


            int mid = rating[j];
            for (int i = 0; i<j; i++) {
                if (rating[i] < mid) smallerBef ++;
                if (rating[i] > mid) greaterBef ++;
            }


            for (int k = j+1; k<len; k++) {
                if (rating[k] > mid) greaterAft ++;
                if (rating[k] < mid) smallerAft ++;
            }

            count += (smallerBef * greaterAft) + (greaterBef * smallerAft);

        }
        System.out.print(count);
    }
}
