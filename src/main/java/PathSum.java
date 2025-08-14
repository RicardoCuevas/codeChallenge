//112. Path Sum
//https://leetcode.com/problems/path-sum/description/?envType=problem-list-v2&envId=binary-tree
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        System.out.println(hasPathSum(root, targetSum));
        //System.out.println(searchPath(root, 0 ,targetSum));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum){
        if(root==null){
            return false;
        }
        int currentValue = targetSum - root.val;
        if(currentValue == 0 && root.left == null && root.right==null){
            return true;
        }
        return hasPathSum(root.left, currentValue) || hasPathSum(root.right, currentValue);
    }

    //Initial Implementation without success
    public static int searchPath(TreeNode root, int sum, int target){
        if (root==null) {
            return sum;
        }

        System.out.println("root.val = " + root.val + " + current sum = "+sum+" = ");
        sum += root.val;
        System.out.println("result sum ="+sum);
        if(sum==target) return sum;
        sum = searchPath(root.left, sum, target);
        sum = searchPath(root.right, sum, target);
        return sum;
    }
}

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There are two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * Example 3:
 *
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */