/**
 * MinimumDistanceBetweenBstNodes
 * 783.Минимальное расстояние между узлами BST
 * @author :Dmitry_Chernikov
 * @version :0.0.0
 * @since :2022-07-21, чт, 13:58
 */

public class MinimumDistanceBetweenBstNodes {
    int p = -1;
    int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        minDiffInBST(root.left);
        if (p != -1) {
            res = Math.min(Math.abs(p - root.val), res);
        }
        p = root.val;
        minDiffInBST(root.right);
        return res;
    }
}
