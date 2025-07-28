import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LevelOrderTraversal {

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = getLevelOrderTraversal(root);
        System.out.println("Reverse level order traversal: " + result);

    }

    public static List<List<Integer>> getLevelOrderTraversal(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int queueSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for(int i = 0; i<queueSize; i++)
            {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);

                if(currNode.left != null)
                {
                    queue.add(currNode.left);
                }

                if(currNode.right != null)
                {
                    queue.add(currNode.right);
                }
            }

            result.add(0, currLevel);
        }

        return result;
    }
}


