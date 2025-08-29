//https://leetcode.com/problems/rotate-array/submissions/1752011913/
//189. Rotate Array

public class Rotate {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        int nums1[] = {1,2};
        int k1 = 7;
        int k = 3;
        //rotate1(nums1, k1);
        optimalSolution(nums, k);
    }

    public static void rotate(int[] nums1, int k1){
//        int index = 0;
//        int [] temp = new int[nums.length];
//        for(int j = nums.length - k; j<nums.length; j++){
//            temp[index] = nums[j];
//            index++;
//        }
//        index = 0;
//        for (int i = k; i<nums.length; i++){
//            temp[i] = nums[index];
//            index++;
//        }
//
//        for (int x=0; x<nums.length; x++){
//            nums[x] = temp[x];
//        }


    }

    public static void rotate1(int[] nums, int k){
        if(nums.length <= 1) return;

        k = k % nums.length; //calcular el numero de rotaciones necesarias

        int[] temp = new int[nums.length];
        int index = 0;

        //Captura los ultimos k numeros en el arreglo temporal
        for (int j=nums.length - k; j<nums.length; j++){
            temp[index] = nums[j];
            index++;
        }

        for (int i=0; i<nums.length - k; i++){
            temp[index] = nums[i];
            index++;
        }

        for (int x=0; x<nums.length; x++){
            nums[x] = temp[x];
        }
        printResult(nums);
    }

    public static void optimalSolution(int[] nums, int k){
        k = k % nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        printResult(nums);
    }

    public static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++ ;
            end --;
        }
    }

    public static void printResult(int nums[]){
        for(int num : nums) System.out.print(num+" ");
    }
}

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */