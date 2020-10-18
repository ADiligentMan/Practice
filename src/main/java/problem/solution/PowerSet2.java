package problem.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 78. Subsets
 *
 * @author wangpeng
 * @since 2020-09-20
 */
public class PowerSet2 {
    List<List<Integer>> powerSet = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        boolean[] selects = new boolean[nums.length];

        int max = (int) Math.pow(2, nums.length) - 1;
        powerSet.add(new LinkedList<>());
        for (int i = 0; i < max; i++) {
            addOne(selects);
            addSubSet(selects, nums);
        }

        return powerSet;
    }

    // 溢出的舍弃
    private void addOne(boolean[] selects) {
        for (int i = selects.length - 1; i >= 0; i--) {
            if (!selects[i]) {
                selects[i] = true;
                return;
            }else {
                selects[i] = false;
            }
        }
    }

    private void addSubSet(boolean[] booleans, int[] nums) {
        List<Integer> integers = new LinkedList<>();
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                integers.add(nums[i]);
            }
        }
        powerSet.add(integers);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new PowerSet2().subsets(nums));
    }

}
