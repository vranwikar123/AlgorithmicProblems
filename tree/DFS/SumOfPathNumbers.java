package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree where each node can only have a digit (0-9) value,
 * each root-to-leaf path will represent a number. Find the total sum of all the numbers represented by all paths.
 */
public class SumOfPathNumbers
{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " +
                findPathsRecursive(root, 0));
    }

    private static int findPathsRecursive(TreeNode currNode, int sum)
    {
        if(currNode == null)
        {
            return 0;
        }

        sum = sum * 10 + currNode.val;

        if (currNode.left == null && currNode.right == null) {
            return sum;
        }

        int res =  findPathsRecursive(currNode.left, sum) + findPathsRecursive(currNode.right, sum);
        return res;

    }
}
