//https://leetcode.com/problems/jump-game/submissions/1752913049/?envType=study-plan-v2&envId=top-interview-150
//55. Jump Game

public class JumpGame {
    public static void main(String[] args) {

        int nums1[] = {2,3,1,1,4};
        boolean expected1 = true;
        int nums2[] = {3,2,1,0,4};
        boolean expected2 = false;
        int nums3[] = {3,2,2,0,4};
        boolean expected3 = true;
        int nums4[] = {8};
        boolean expected4 = true;
        int nums5[] = {0,0,0,4};
        boolean expected5 = false;
        int nums6[] = {0,2};
        boolean expected6 = false;

        System.out.println("Actual Result: "+canJump(nums1) +" Expected Result: "+expected1);
        System.out.println("Actual Result: "+canJump(nums2) +" Expected Result: "+expected2);
        System.out.println("Actual Result: "+canJump(nums3) +" Expected Result: "+expected3);
        System.out.println("Actual Result: "+canJump(nums4) +" Expected Result: "+expected4);
        System.out.println("Actual Result: "+canJump(nums5) +" Expected Result: "+expected5);
        System.out.println("Actual Result: "+canJump(nums6) +" Expected Result: "+expected6);
    }

    public static boolean canJump(int[] nums){
        if(nums.length==1) return true;
        int target = nums.length -1;
        int indexActual = 0;
        int maxJump = 0;
        boolean flag = false;
        for (indexActual = nums.length-2; indexActual>=0; indexActual--){
            maxJump = nums[indexActual];
            if( target - indexActual <= maxJump){
                flag = true;
                target = indexActual;
            }
            else {
                flag = false;
            }
        }
        return flag;
    }
}

/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105

* */