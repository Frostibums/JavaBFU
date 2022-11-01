package lab1;

import lab1.Problem1;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class test_Problem1 {

    @Test
    public void shouldReturnTrue_ifNumberContainsAInHexRepresentation() {
        // given
        int number = 26;

        // when
        boolean actual = Problem1.containsDigitAInHexadecimalRepresentation(number);

        // then
        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalse_ifNumberDoesNotContainAInHexRepresentation() {
        // given
        int number = 18;

        // when
        boolean actual = Problem1.containsDigitAInHexadecimalRepresentation(number);

        // then
        assertFalse(actual);
    }

}
