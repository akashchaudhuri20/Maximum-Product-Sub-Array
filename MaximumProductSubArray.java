/*
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * A sub array is a contiguous subsequence of the array.
 *
 * Example 1
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */

import java.util.Arrays;

public class MaximumProductSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 0, -1};
        System.out.print(getMaximumProduct(nums));
    }

    private static int getMaximumProduct(int[] nums) {
        int res = Arrays.stream(nums).max().getAsInt();
        int currentMax = 1;
        int currentMin = 1;
        for (int n : nums) {
            if (n == 0) {
                currentMax = 1;
                currentMin = 1;
            }
            int temp = currentMax;
            currentMax = Math.max(currentMax * n, Math.max(currentMin * n, n));
            currentMin = Math.min(temp, Math.max(currentMin * n, n));
            res = Math.max(res, Math.max(currentMax, currentMin));
        }
        return res;

    }
}
