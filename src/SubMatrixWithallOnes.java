import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubMatrixWithallOnes {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,0,0},{0,1,0},{0,1,0},{1,1,1},{1,1,0}};

        int row = matrix.length;
        int col = matrix[0].length;

        int n = Math.min(row, col);

        int count = 0;

        List<Integer[]> index = new ArrayList<>();

        for (int i = 1; i<=n; i++) {
            count += calculate(i, matrix, row, col, index);
        }

        System.out.print(count);
    }

    static int calculate(int n, int[][] matrix, int row, int col, List<Integer[]> index) {
        int count = 0;
        if (n == 1) {
            for (int i = 0; i<row; i++) {
                for (int j = 0; j<col; j++){
                    if (matrix[i][j] == 1) {
                        Integer[] k = new Integer[2];
                        k[0] = i;
                        k[1] = j;
                        index.add(k);
                        count ++;
                    }
                }
            }
            return count;
        }

        int i = 0;
        while (i < index.size()) {

            int rr = index.get(i)[0];
            int cc = index.get(i)[1];
            boolean flg = true;
            if ( (rr + n -1) < row && (cc + n - 1) < col) {
                for (int r = rr; r<= rr+n-1; r++){
                    if (matrix[r][cc+n-1] != 1) {
                        flg = false;
                        break;
                    }
                }
                if(!flg) {
                    index.remove(i);
                    continue;
                }
                for (int c = cc; c<= cc+n-1; c++){
                    if (matrix[rr+n-1][c] != 1) {
                        flg = false;
                        break;
                    }
                }
                if(!flg) {
                    index.remove(i);
                    continue;
                }
            } else{
                index.remove(i);
                continue;
            }
            if(flg) {
                count++;
                i++;
            }
        }

        return count;
    }


}
