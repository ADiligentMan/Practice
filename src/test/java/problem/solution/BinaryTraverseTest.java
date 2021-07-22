package problem.solution;


import org.junit.Test;
import problem.solution.model.BNode;

import java.util.List;

public class BinaryTraverseTest {
    @Test
    public void test1() {
        BNode root = new BNode();
        root.value = 3;
        BNode node = new BNode();;
        node.value = 9;
        root.left = node;
        node = new BNode();
        node.value = 20;
        root.right = node;
        node = new BNode();
        node.value = 15;
        root.right.left = node;
        node = new BNode();
        node.value = 7;
        root.right.right = node;

        BinaryTraverse binaryTraverse = new BinaryTraverse();
        List<List<Integer>> listList = binaryTraverse.traverse(root);
        System.out.println(listList);
    }


}