package lab1;
import java.util.Arrays;
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args){
        String numbers = "1, 32, 2, 4, 8, 16";
        System.out.println(isGeometricProgression(numbers));
    }

    public static boolean isGeometricProgression(String numbers) {
        // TODO: implement this method
        String strArr[] = numbers.split(", ");

        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(numArr);

        for (int i = 0; i < numArr.length-2; i++) {
            if(numArr[i+1] / numArr[i] != numArr[i+2] / numArr[i+1]){
                return false;
            }
        }
        return true;
    }
}