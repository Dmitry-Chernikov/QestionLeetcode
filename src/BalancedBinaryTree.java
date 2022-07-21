/**
 * BalancedBinaryTree
 * Сбалансированное бинарное дерево
 * @author :Dmitry_Chernikov
 * @version :0.0.0
 * @since :2022-07-21, чт, 13:52
 */
public class BalancedBinaryTree {
    //рекурсивная функция проверяет максимальную длину узла в каждом узле и ищет сбалансированный узел
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        if (Math.abs(leftMaxDepth - rightMaxDepth) > 1) {
            return false;
        }
        // Теперь проверяем каждый узел и выстраиваем цепочку с условием && так, чтобы если какой-либо узел вернет false, цепочка приведет к возврату метода isBalanced
        boolean resLeft = isBalanced(root.left);
        boolean resRight = isBalanced(root.right);

        return resLeft && resRight;
    }

    // сначала найти максимальную глубину на узле
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
