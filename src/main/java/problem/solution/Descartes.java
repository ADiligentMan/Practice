package problem.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangpeng
 * @since 2021-01-27
 */
public class Descartes {
    private List<List<String>> list = new LinkedList<>();
    private List<String> sub = new LinkedList<>();


    public List<List<String>> descartes(List<String[]> dimvalue) {
        recursive(0,dimvalue);
        return list;
    }

    public void recursive(int idx, List<String[]> dimvalue) {
        if (sub.size() == dimvalue.size()) {
            List<String> tmp = new LinkedList<>(sub);
            list.add(tmp);
        }
        if (idx >= dimvalue.size()) {
            return;
        }
        String[] value = dimvalue.get(idx);
        for (int i = 0; i < value.length; i++) {
            sub.add(value[i]);
            recursive(idx + 1, dimvalue);
            sub.remove(sub.size()-1);
        }
    }
}
