/**
 * MinimumDepthOfBinaryTree
 * 111.Минимальная глубина бинарного дерева
 * @author :Dmitry_Chernikov
 * @version :0.0.0
 * @since :2022-07-21, чт, 13:58
 */
import java.util.*;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

/*    public int minDepth(TreeNode root) {
        //Очередь где будем хранить перебираемые узлы
        Queue<TreeNode> tNQ = new LinkedList(Arrays.asList(root));
        int minDepth = 0;//Переменная для храненения минимальной глубины дерева

        if (root != null) { //Проверка узла переданного в функцию
            while (!tNQ.isEmpty()) { //Пока очередь не пуста выполняем цикл
                minDepth ++;
                int sizeQueue = tNQ.size(); //Сохраняем размер очереди
                while (sizeQueue > 0){ //Перебираем в очереди добавленные узлы
                    TreeNode treeNode = tNQ.remove();
                    if (treeNode.left == null && treeNode.right == null) return minDepth;

                    //Если ссылка на левый узел не пуста то добавляем в его в конец очереди
                    if (treeNode.left != null) tNQ.offer(treeNode.left);
                    //Если ссылка на правый узел не пуста то добавляем в его в конец очереди
                    if (treeNode.right != null) tNQ.offer(treeNode.right);
                    sizeQueue--;
                }
            }
        }
        // Возврат минимальной глубины бинарного дерева
        return minDepth;
    }*/

    /*public int minDepth(TreeNode root) {
        //Очередь где будем хранить перебираемые узлы
        Queue<TreeNode> tNQ = new LinkedList(Arrays.asList(root));
        int minDepth = 0;//Переменная для храненения минимальной глубины дерева

        if (root != null) { //Проверка узла переданного в функцию
            while (!tNQ.isEmpty()) { //Пока очередь не пуста выполняем цикл
                minDepth ++;
                Queue<TreeNode> subTNQ = new LinkedList<TreeNode>();
                for (TreeNode treeNode: tNQ) {
                    if (treeNode.left == null && treeNode.right == null) return minDepth;

                    //Если ссылка на левый узел не пуста то добавляем в его в конец очереди
                    if (treeNode.left != null) subTNQ.offer(treeNode.left);

                    //Если ссылка на правый узел не пуста то добавляем в его в конец очереди
                    if (treeNode.right != null) subTNQ.offer(treeNode.right);
                }
                tNQ = subTNQ;
            }
        }
        // Возврат минимальной глубины бинарного дерева
        return minDepth;
    }*/
}
