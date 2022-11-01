package lab1;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem2 {
    public static void main(String[] args){
        int array[];
        array = new int[]{2, 6, 12, 68, 34, 16, 92, 52, 68, 8};
        System.out.println(Arrays.toString(segregateEvenAndOddNumbers(array)));
    }

    public static int[] segregateEvenAndOddNumbers(int[] array) {
        // TODO: implement this method

        int length = array.length;
        int[] sep = new int[length];
        int index = 0;

        for (int i = 0; i < length; i++){
            if(array[i] % 2 == 0){
                sep[index] = array[i];
                index++;
            }
        }

        for (int i = 0; i < length; i++){
            if(array[i] % 2 != 0){
                sep[index] = array[i];
                index++;
            }
        }

        return sep;
    }
}

