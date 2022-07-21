/**
 * BinaryTreeLevelOrderTraversal
 * Порядковый обход двоичного дерева
 * @author :Dmitry_Chernikov
 * @version :0.0.0
 * @since :2022-07-21, чт, 13:53
 */
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //Очередь где будем хранить перебираемые узлы
        Queue<TreeNode> nodesQueue = new LinkedList<TreeNode>();
        //Результат который будем возвращать из функции
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root != null) { //Проверка узла переданного в функцию
            nodesQueue.offer(root); //Помещаем в очередь первый узел
            while (!nodesQueue.isEmpty()) { //Пока очередь не пуста выполняем цикл
                int sizeQueue = nodesQueue.size(); //Сохраняем размер очереди
                List<Integer> subList = new LinkedList<>();//Создаём промежуточный List
                for (int i = 0; i < sizeQueue; i++) { //Перебираем в очереди добавленные узлы
                    //Если ссылка на левый узел не пуста то добавляем в его в конец очереди
                    if (nodesQueue.peek().left != null) nodesQueue.offer(nodesQueue.peek().left);
                    //Если ссылка на правый узел не пуста то добавляем в его в конец очереди
                    if (nodesQueue.peek().right != null) nodesQueue.offer(nodesQueue.peek().right);
                    //Добавляем в под List значения узла или узлов
                    subList.add(nodesQueue.poll().val);
                }
                //Добавляем в результирующий List промежуточный List
                result.add(subList);
            }
        }
        //Возвращаем результирующий List
        return result;
    }
}

