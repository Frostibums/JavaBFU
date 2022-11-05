package lab1;
import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int [][] matrix = { {1, 2, 3, 0},
                            {4, 5, 6, 0},
                            {7, 8, 9, 0}};
        System.out.println(Arrays.toString(flattenMatrix(matrix)));
    }

    public static int[] flattenMatrix(int[][] matrix) {
        // TODO: implement this method
        if (matrix.length == 0)
            return new int[0];

        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n*m];
        int index=0;

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[index] = matrix[j][i];
                index++;
            }
        }

        return res;
    }
}