import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /**
     * !Counting Sum Pairs Coding Task Examples
     * X: 1
     * Array: [3, 4, 5, 6]
     * Output: 0
     *
     * X: 15
     * Array: [0, 15, 32, 2000, 15000]
     * Output: 1
     *
     * X: 42
     * Array: [1, 1, 10, 32, 41]
     * Output: 2
     */
    public static void main(String[] args) {
        /** !DesignChoice:
         * Technically this Class and it's Methods could have been static as it doesn't have a state to manage,
         * but I didn't see much of a point to add complication for no foreseeable benefit.
         * */
        Calculator calculator = new Calculator();

        // Console sugar
        System.out.println("----------------------------------");

        /** !DesignChoice:
         * Arraylists are never used after the calculation, so no point assigning them to variables beforehand.
         */
        calculator.calculateUniqueSumPairs(new ArrayList<>(Arrays.asList(3,4,5,6)), 1);
        calculator.calculateUniqueSumPairs(new ArrayList<>(Arrays.asList(0, 15, 32, 2000, 15000)), 15);
        calculator.calculateUniqueSumPairs(new ArrayList<>(Arrays.asList(1, 1, 10, 32, 41)), 42);
    }
}