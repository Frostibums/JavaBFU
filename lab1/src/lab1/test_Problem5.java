package lab1;

import lab1.Problem5;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test_Problem5 {

    @Test
    public void shouldReturnTrue_ifStringIsSortedGeometricProgression() {
        // given
        String geometricProgression = "1, 2, 4, 8, 16";

        // then
        assertTrue(Problem5.isGeometricProgression(geometricProgression));
    }

    @Test
    public void shouldReturnTrue_ifStringIsUnsortedGeometricProgression() {
        // given
        String geometricProgression = "1, 3, 27, 9, 243, 81";

        // then
        assertTrue(Problem5.isGeometricProgression(geometricProgression));
    }

    @Test
    public void shouldReturnTrue_ifStringIsNotGeometricProgression() {
        // given
        String geometricProgression = "1, 3, 15, 27, 81, 9";

        // then
        assertFalse(Problem5.isGeometricProgression(geometricProgression));
    }
}
