package problem.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 78. Subsets
 *
 * @author wangpeng
 * @since 2020-09-20
 */
public class PowerSet {
    List<List<Integer>> powerSet = new LinkedList<>();
    List<Integer> subSet = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        recursive(nums, 0, true);
        subSet.remove(subSet.size() - 1);
        recursive(nums, 0, false);
        return powerSet;
    }

    private void recursive(int[] nums, int cursor, boolean select) {
        // 选择当前元素
        if (select) {
            subSet.add(nums[cursor]);
        }
        if(cursor == nums.length - 1){
            powerSet.add((List<Integer>)((LinkedList)subSet).clone());
            return;
        }
        recursive(nums, cursor + 1, true);
        subSet.remove(subSet.size() - 1);
        recursive(nums, cursor + 1, false);
    }
}
