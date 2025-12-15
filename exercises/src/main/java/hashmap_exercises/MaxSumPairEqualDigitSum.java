package hashmap_exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2342 - Max Sum of a Pair With Equal Sum of Digits
 *
 * You are given a 0-indexed integer array nums.
 * Find the maximum sum of a pair of numbers (nums[i] + nums[j]) such that
 * the sum of digits of nums[i] is equal to the sum of digits of nums[j],
 * and i != j.
 *
 * If no such pair exists, return -1.
 *
 * Example:
 * nums = [18, 43, 36, 13, 7]
 * digit sums: 9, 7, 9, 4, 7
 * Pairs with same digit sum:
 *   (18, 36) -> sum = 54 with digit sum 9
 *   (43, 7)  -> sum = 50 with digit sum 7
 * Answer: 54
 */
public class MaxSumPairEqualDigitSum {

    /**
     * @param nums input array
     * @return maximum sum of a pair of numbers sharing the same digit sum,
     *         or -1 if no such pair exists
     */
    public int maximumSum(int[] nums) {

        Map<Integer, Integer> sums = new HashMap<>();
        int greatestDigitSum = -1;

        for(int num :nums){

            //if same digit sum was already found
            if(sums.containsKey(digitSum(num))){
                int newSum = sums.get(digitSum(num)) + num;
                if(newSum>greatestDigitSum){
                    greatestDigitSum = newSum;
                }
            }
            //if the number is greater than the other number with the same digitSum update with the new number
            //This way if there are more than two values with the same digitSum it will return the highest sum
            if(!sums.containsKey(digitSum(num)) || num > sums.get(digitSum(num)) ){
                sums.put(digitSum(num), num);
            }
        }
        return greatestDigitSum;
    }

    /**
     * Optional helper method:
     * Computes the sum of digits of a non-negative integer.
     */
    int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}

