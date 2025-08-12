//35. Search Insert Position
//https://leetcode.com/problems/search-insert-position/description/

import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println("Actual Result "+ searchInsert(nums,target) + " Expected result = 2");

        int target1 = 2;
        System.out.println("Actual Result "+ searchInsert(nums,target1) + " Expected result = 1");

        int target2 = 7;
        System.out.println("Actual Result "+ searchInsert(nums,target2) + " Expected result = 4");

    }

    public static int searchInsert(int[] nums, int target){
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        while(leftPointer<=rightPointer){
            int mid = leftPointer + (rightPointer - leftPointer)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                leftPointer = mid + 1;
            }
            else if(nums[mid]>target){
                rightPointer = mid-1;

            }
        }
        return leftPointer;
    }

    public static int searchInsert1(int[] nums, int target){
        int result = Arrays.binarySearch(nums, target);
        if(result<0) return Math.abs(result + 1);
        return result;
    }

}

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
