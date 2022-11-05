package lab1;

import lab1.Problem2;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class test_Problem2 {

    @Test
    public void shouldReturnSegregateEvenAndOddNumbers_ifArrayIsMixed() {
        // given
        int[] mixedEvenAndOdds = new int[]{2, 1, 12, 68, 34, 1, 9, 5, 6, 8};

        // when
        int[] segregatedEvenAndOdds = new int[]{2, 12, 68, 34, 6, 8, 1, 1, 9, 5};

        // then
        assertArrayEquals(segregatedEvenAndOdds, Problem2.segregateEvenAndOddNumbers(mixedEvenAndOdds));
    }

    @Test
    public void shouldReturnSegregateEvenAndOddNumbers_ifArrayIsAllOdds() {
        // given
        int[] mixedEvenAndOdds = new int[]{2, 6, 12, 68, 34, 16, 92, 52, 68, 8};

        // when
        int[] segregatedEvenAndOdds = new int[]{2, 6, 12, 68, 34, 16, 92, 52, 68, 8};

        // then
        assertArrayEquals(segregatedEvenAndOdds, Problem2.segregateEvenAndOddNumbers(mixedEvenAndOdds));
    }

    @Test
    public void shouldReturnSegregateEvenAndOddNumbers_ifArrayIsAllEven() {
        // given
        int[] mixedEvenAndOdds = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        // when
        int[] segregatedEvenAndOdds = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        // then
        assertArrayEquals(segregatedEvenAndOdds, Problem2.segregateEvenAndOddNumbers(mixedEvenAndOdds));
    }
}
