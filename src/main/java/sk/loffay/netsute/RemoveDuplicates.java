package sk.loffay.netsute;

/**
 * @author Pavol Loffay
 *
 * Question 1 A:
 * I changed solution my removeDuplicates returns new array without duplicates.
 * If input array is null or unsorted IllegalArgumentException is thrown.
 * I modified it because I didn't know what values to put in place of duplicates
 * e.g. If I put 0:
 * input -2,-3,0,0,0
 * result: -2,-3,0,0,0 > that is not good
 *
 * Questions (answer these):
 * 1. Did you write that as if you were writing production code?
 * 2. What assumptions does your implementation make about the input parameter?
 * 3. What is removeDuplicates(x).length, in your implementation?
 * 4. Are you using all the information you have about the input array?
 * 5. What is the algorithmic complexity ("big O") of your function?
 *
 * 1: I did write it as production code
 * 2: Method can take any input parameter - null, unsorted, sorted
 * 3: removeDuplicates(x).length if there are no duplicates is the same as x.length,
 *      in other cases is less than x.length
 * 4: Yes all information
 * 5: Complexity is linear O(2*N)
 */
public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] values) {

        if (values == null) {
            throw new IllegalArgumentException("Cannot remove duplicates from null.");
        }

        if (values.length == 0) {
            return values;
        }

        int[] valuesWithoutDuplicates = new int[values.length];

        // change first value
        int previous = values[0]>>1;
        int indexWithoutDuplicates = 0;

        for (int i = 0; i < values.length; i++) {
            if (i > 0 && values[i] < previous) {
                throw new IllegalArgumentException("Array is not sorted");
            }

            if (values[i] != previous) {
                valuesWithoutDuplicates[indexWithoutDuplicates++] = values[i];
                previous = values[i];
            }
        }

        // create result, valuesWithoutDuplicates can contain unused indices
        int[] result = new int[indexWithoutDuplicates];
        for (int i = 0; i < result.length; i++) {
            result[i] = valuesWithoutDuplicates[i];
        }

        return result;
    }
}
