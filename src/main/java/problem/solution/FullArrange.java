package problem.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangpeng
 * @since 2021-01-27
 */
public class FullArrange {
    List<List<String>> results = new LinkedList<>();
    List<String> sub = new LinkedList<>();

    public List<List<String>> fullArrange(List<String> elements) {
        recursive(elements, elements.size());
        return results;
    }

    private void recursive(List<String> elements, final int size) {
        if (sub.size() == size) {
            results.add(new LinkedList<>(sub));
        }
        if (elements.size() == 0) {
            return;
        }
        List<String> tmp = new LinkedList<>(elements);
        for (int i = 0; i < tmp.size(); i++) {
            List<String> tmpInner = new LinkedList<>();
            tmpInner.addAll(tmp);
            tmpInner.remove(i);
            sub.add(tmp.get(i));
            recursive(tmpInner, size);
            sub.remove(sub.size() - 1);
        }
    }
}
