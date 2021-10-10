import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int numRows = 5;

        for (int i = 1; i<= numRows; i++) {
            List<Integer> row = Arrays.asList(new Integer[i]);
            Collections.fill(row, 1);
            result.add(row);
        }

        for(int i = 2; i<numRows; i++) {
            for (int j = 1; j<i; j++ ) {
                result.get(i).set(j, result.get(i-1).get(j-1) + result.get(i-1).get(j) );
            }
        }

        //result.forEach(k -> k.forEach(l -> System.out.print(" " + l)));
    }
}
