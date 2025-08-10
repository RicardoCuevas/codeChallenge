//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
public class SortedArrayTree {

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        preOrder(sortedArrayToBST(nums));
        System.out.println();
        postOrder(sortedArrayToBST(nums));
        System.out.println();
        levelOrder(sortedArrayToBST(nums));
    }

    public static TreeNode sortedArrayToBST(int[] nums){
        if(nums==null || nums.length == 0) return null;
        return recursiveNode(nums, 0, nums.length-1);
    }

    public static TreeNode recursiveNode(int[] nums, int left, int right){
        if(left>right) return null;
        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recursiveNode(nums, left, mid-1);
        node.right = recursiveNode(nums, mid+1, right);
        return node;
    }

    static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    static void levelOrder(TreeNode root) {
        if (root == null) return;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }
}

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */