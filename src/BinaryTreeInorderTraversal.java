/**
 * BinaryTreeInorderTraversal
 * 94.Неупорядоченный обход двоичного дерева
 * @author :Dmitry_Chernikov
 * @version :0.0.0
 * @since :2022-07-21, чт, 13:53
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}
