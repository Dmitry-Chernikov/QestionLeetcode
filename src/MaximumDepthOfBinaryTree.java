/**
 * MaximumDepthOfBinaryTree
 * Максимальная глубина бинарного дерева
 * @author :Dmitry_Chernikov
 * @version :0.0.0
 * @since :2022-07-21, чт, 13:54
 */

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.right) + 1, maxDepth(root.left) + 1);
    }
}
