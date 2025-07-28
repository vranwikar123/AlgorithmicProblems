import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return an array containing the largest value in each row of the tree (0-indexed).
 *
 * Examples
 * Example 1
 * Input: root = [1, 2, 3, 4, 5, null, 6]
 * Expected Output: [1, 3, 6]
 */


public class LargestValueEachRow
{
    public static void main(String[] args)
    {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(6);

        List<Integer> output1 = getLargestValueEachRow(root1);
        System.out.println("Example 1 Output: " + output1);  // Expected Output: [1, 3, 6]
    }

    private static List<Integer> getLargestValueEachRow(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int queueSize = queue.size();
            int localMax = Integer.MIN_VALUE;

            for(int i = 0; i<queueSize; i++)
            {
                TreeNode currNode = queue.poll();
                localMax = Math.max(localMax, currNode.val);
                if(currNode.left != null)
                {
                    queue.add(currNode.left);
                }

                if(currNode.right != null)
                {
                    queue.add(currNode.right);
                }
            }

            result.add(localMax);
        }

        return result;
    }
}
