package lab1;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println((containsDigitAInHexadecimalRepresentation(number)));
    }

    public static boolean containsDigitAInHexadecimalRepresentation(int number) {
        return Integer.toHexString(number).contains("a");
    }
}

