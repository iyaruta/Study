/**
 * User: Alexandr
 * Date: 07.10.2014
 */
public class Main {

    public static void main(String[] args) {

        /*
            Следующие 3 строки создают дерево:
                     1
                  /    \
                2       3
              /  \    /  \
            2_1  2_2 3_1  3_2

         */
        Node root = new Node("1");
        root.left = new Node("2", new Node("2_1"), new Node("2_2"), root);
        root.right = new Node("3", new Node("3_1"), new Node("3_2"), root);
        //дерево создано, начинаем обходить в глубину

        Node current = root; //временная переменная, что бы помнить вершину, на которой мы находимся
        Node prev = root; //временная переменная, что бы помнить где мы были перед этим, нужно что бы правильно вернуться и опять не идти влгубь
        int i = 0; //количество вершин
        while (current != null) { //когда текущая вершина будет пустой, значит мы обошли и левую и правую ветки и значит цикл остановится
            if (current.left != null && current.left != prev && current.right != prev) { //читай описание ниже в блоке 1
                prev = current;
                current = current.left;
            } else if (current.right != null && current.right != prev) { //если есть правая ветки И она не является prev (значит, что мы в ней еще не были), берем ее за текущую
                prev = current;
                current = current.right;
            } else {
                prev = current;
                current = current.parent; //берем родителя
                if (current == null) { //нужно, что бы считать root
                    i++;
                }
                continue; //принудительно возвращает нас на while и начинает новую итерацию цикла (код дальше не выполнится, нужно что бы не плюсовать i когда возвращаемся назад)
            }

            System.out.println(current.name);
            i++;
        }

        System.out.println(i);
    }
}
