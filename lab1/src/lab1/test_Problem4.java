package lab1;

import lab1.Problem4;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class test_Problem4 {

    @Test
    public void shouldReturnFlatMatrix_ifMatrixIsSquare() {
        // given
        int[][] matrix = new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        int[] flatMatrix = new int[]{1, 4, 7, 2, 5, 8, 3, 6, 9};

        // then
        assertArrayEquals(flatMatrix, Problem4.flattenMatrix(matrix));
    }

    @Test
    public void shouldReturnFlatMatrix_ifRowsMoreThanColumns() {
        // given
        int[][] matrix = new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                        {10, 11, 12}
                };

        int[] flatMatrix = new int[]{1, 4, 7, 10, 2, 5, 8, 11, 3, 6, 9, 12};

        // then
        assertArrayEquals(flatMatrix, Problem4.flattenMatrix(matrix));
    }

    @Test
    public void shouldReturnFlatMatrix_ifColumnsMoreThanRows() {
        // given
        int[][] matrix = new int[][]
                {
                        {1, 2, 3, 4},
                        {4, 5, 6, 7},
                        {7, 8, 9, 10}
                };

        int[] flatMatrix = new int[]{1, 4, 7, 2, 5, 8, 3, 6, 9, 4, 7, 10};

        // then
        assertArrayEquals(flatMatrix, Problem4.flattenMatrix(matrix));
    }
}
