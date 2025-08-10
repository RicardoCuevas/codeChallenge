// 104. Maximum Depth of Binary Tree
// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(9);
        root.right = new TreeNode(2);
        //root.right.left = new TreeNode(15);
        //root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right==null) return 1;
        return recursive(root, 0);
    }

    public static int recursive(TreeNode node, int count) {
        if(node==null) return count;
        count++;
        return Math.max(recursive(node.left, count), recursive(node.right, count));
    }

}

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */