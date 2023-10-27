import model.StateNumber;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Calculator {

    /**
     * !Counting Sum Pairs Coding Task
     * Write a function which takes 2 parameters: an array of whole numbers and an integer X.
     *
     * The function should look for pairs of numbers in the array which sum to X.
     * Each array element can only be used in one pair.
     * The function should return the count of how many such pairs it finds.
     *
     * You may assume that the array passed to the function has already been sorted in ascending order.
     *
     * State any assumptions or design choices you have made.
     *
     * @param numberList Array of numbers to find sum pairs.
     * @param sum Sum value that the pairs need to add up to.
     */
    public void calculateUniqueSumPairs(ArrayList<Integer> numberList, int sum){
        ArrayList<StateNumber> stateNumbers = new ArrayList<>();
        int sumCount = 0;

        System.out.println("Calculating unique pairs that sum to " + sum);
        System.out.println("Using list: " + numberList.stream().map(Object::toString)
                .collect(Collectors.joining(", ")));

        // Encapsulate the numbers as model.StateNumber objects, so duplicate uses can be avoided.
        for (Integer number : numberList) {
            // Default handling of Integer -> Int potential null values.
            if(number != null)
                stateNumbers.add(new StateNumber(number));
        }

        /** !DesignChoice:
         * The problem here is that once a number has been used in a pair, it cannot be used again in a 2nd pair.
         *
         * Using an array/list and removing elements once they have been used is complex as you are already iterating
         * over it, so you would need to have complex logic to duplicate the array beforehand, remove the numbers when
         * used, then marry up which elements have already been removed with the first array.
         *
         * My second thought was using HashMap to have a 'number':'state' structure, however this would not allow
         * duplicate keys (numbers in the array), which is essential for the examples given.
         *
         * MultiMap could potentially have been used as an implementation, however the logic would have been the same,
         * so I chose to use a custom model.StateNumber object (which I find easier to read/interrogate/debug with).
         */
        // Loop through the array to compare a single number to all others.
        for(int i = 0; i < stateNumbers.size(); i++){
            // If the number is already used in a pair, then it will be inactive.
            if(stateNumbers.get(i).isActive()){
                // Start the pair comparison on the next number in the array.
                for(int j = i + 1; j < stateNumbers.size(); j++){
                    // The 2nd number in the array (index j) can't already be used, so check that first.
                    if(     stateNumbers.get(j).isActive() &&
                            stateNumbers.get(i).getNumber() + stateNumbers.get(j).getNumber() == sum){
                        System.out.println("Found pairing equal to sum: " +
                                stateNumbers.get(i).getNumber() + " + " + stateNumbers.get(j).getNumber());
                        stateNumbers.get(i).setActive(false);
                        stateNumbers.get(j).setActive(false);
                        sumCount++;
                    }
                }
            }
        }
        System.out.println("Sum count is: " + sumCount);
        // Console sugar
        System.out.println("----------------------------------");
    }
}
