package problem.solution;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class FullArrangeTest {

    @Test
    public void test() {
        List<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        FullArrange fullArrange = new FullArrange();
        System.out.println(fullArrange.fullArrange(list));
    }

}