package DFS;


import java.util.ArrayList;
import java.util.List;

public class AllPathsForSum
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

    private static List<List<Integer>> findPaths(TreeNode root, int sum)
    {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode currNode, int sum, List<Integer> currentPath,
                                           List<List<Integer>> allPaths)
    {
        if(currNode == null)
        {
            return;
        }

        currentPath.add(currNode.val);

        if(currNode.left == null && currNode.right == null && currNode.val == sum)
        {
            allPaths.add(new ArrayList<>(currentPath));
        }
        else
        {
            findPathsRecursive(currNode.left, sum - currNode.val, currentPath, allPaths);
            findPathsRecursive(currNode.right, sum - currNode.val, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size()-1);
    }
}
