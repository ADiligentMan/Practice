package problem.solution;

import problem.solution.model.BNode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTraverse {

    public List<List<Integer>> traverse(BNode node) {
        if (node == null) {
            return null;
        }

        List<List<Integer>> results = new LinkedList<>();
        List<BNode> list = new LinkedList<>();
        list.add(node);
        List<BNode> listTmp = new LinkedList<>();

        // 先 right left 后 left right
        boolean rightLeft = true;
        LinkedList<Integer> subResult = new LinkedList<>();
        subResult.add(node.value);
        results.add(subResult);
        while (list.size() > 0 || listTmp.size() > 0) {
            if (list.size() == 0) {
                results.add(listTmp.stream().map(node1 -> node1.value).collect(Collectors.toList()));
                for (int i = listTmp.size() - 1; i >= 0; i--) {
                    list.add(listTmp.get(i));
                }
                listTmp.clear();
                rightLeft = !rightLeft;
            }

            BNode tmpNode = list.remove(0);

            if (rightLeft) {
                if (tmpNode.right != null) {
                    listTmp.add(tmpNode.right);
                }
                if (tmpNode.left != null) {
                    listTmp.add(tmpNode.left);
                }
            } else {
                if (tmpNode.left != null) {
                    listTmp.add(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    listTmp.add(tmpNode.right);
                }
            }
        }

        return results;
    }


}

