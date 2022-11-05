package lab1
import java.util.Arrays;
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args){
        String numbers = "4, 2, 8, 32, 16";
        System.out.println(isGeometricProgression(numbers));
    }

    public static boolean isGeometricProgression(String numbers) {
        // TODO: implement this method
        String strArr[] = numbers.split(", ");

        int len = strArr.length;
        if (len < 2)
            return false;

        int numArr[] = new int[len];
        for (int i = 0; i < len; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(numArr);

        int step = numArr[1]/numArr[0];

        for (int i = 0; i < numArr.length-1; i++) {
            if(numArr[i] * step != numArr[i+1]){
                return false;
            }
            if(numArr[i]==numArr[i+1])
                return false;
        }
        return true;
    }
}