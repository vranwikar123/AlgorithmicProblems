import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NArrayLevelOrder {

    public static void main(String[] args) {




    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            List<Integer> lst = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i< size; i++)
            {
                Node nd = queue.poll();
                lst.add(nd.val);
                for(Node n: nd.children)
                {
                    queue.add(n);
                }
            }
            result.add(lst);
        }

        return result;
    }
}