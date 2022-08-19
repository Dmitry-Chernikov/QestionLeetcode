/**
 * BinaryTreePostorderTraversal
 * 145.Обход двоичного дерева в обратном порядке
 * @author :Dmitry_Chernikov
 * @version :0.0.0
 * @since :2022-07-21, чт, 13:54
 */
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    List<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);

        return res;
    }
}
