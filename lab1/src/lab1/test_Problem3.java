package lab1;

import lab1.Problem3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_Problem3 {

    @Test
    public void shouldSolveKnapsackProblem_ifWeightsAndValuesAreRegular() {
        // given
        double[] values = new double[]{2.0, 1.0, 5.0};
        double[] weights = new double[]{1.0, 1.0, 2.0};
        double maximumWeightCapability = 2.5;

        // when
        double correctAnswer = 5.0;

        // then
        assertEquals(correctAnswer,Problem3.solveKnapsackProblem(values, weights, maximumWeightCapability, values.length), 0.01);
    }

    @Test
    public void shouldSolveKnapsackProblem_ifWeightsAndValuesAreDouble() {
        // given
        double[] values = new double[]{0.0, 2.4, 10.0, 5.0, 100.0};
        double[] weights = new double[]{1.0, 0.8, 0.2, 2.0, 1.0};
        double maximumWeightCapability = 2.5;

        // when
        double correctAnswer = 112.4;

        // then
        assertEquals(correctAnswer,Problem3.solveKnapsackProblem(values, weights, maximumWeightCapability, values.length), 0.01);
    }

    @Test
    public void shouldNotSolveKnapsackProblem_ifMaximumWeihtCapabilityIsZero() {
        // given
        double[] values = new double[]{6.3, 12.0, 5.0};
        double[] weights = new double[]{0.2, 14.0, 2.0};
        double maximumWeightCapability = 0.0;

        // when
        double correctAnswer = 0;

        // then
        assertEquals(correctAnswer,Problem3.solveKnapsackProblem(values, weights, maximumWeightCapability, values.length), 0.01);
    }

}
