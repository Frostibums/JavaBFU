package lab1;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        double[] values = {0.0, 2.4, 10.0, 5.0, 100.0};
        double[] weights = {1.0, 0.8, 0.2, 2.0, 1.0};
        double maximumWeightCapacity = 2.5;
        System.out.println(solveKnapsackProblem(values, weights, maximumWeightCapacity, values.length));
    }


    public static double solveKnapsackProblem(double[] values, double[] weights, double maximumWeightCapacity, int n) {
        // TODO: implement this method
        if (n == 0 || maximumWeightCapacity == 0)
            return 0;

        if (weights[n - 1] > maximumWeightCapacity)
            return solveKnapsackProblem(values, weights, maximumWeightCapacity, n - 1);

        double a = values[n - 1] + solveKnapsackProblem(values, weights, maximumWeightCapacity-weights[n-1], n - 1);
        double b = solveKnapsackProblem(values, weights, maximumWeightCapacity, n - 1);
        return (a>b) ? a:b;
        }
}
