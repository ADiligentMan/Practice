package problem.solution;


import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class DescartesTest {
    @Test
    public void test1() {
        String[] a = {"1", "2"};
        String[] b = {"3", "4"};
        String[] c = {"a", "b"};
        List<String[]> input = new LinkedList<>();
        input.add(a);
        input.add(b);
        input.add(c);

        Descartes descartes = new Descartes();
        System.out.println(descartes.descartes(input));

    }

}