package algorithm.sort;

/**
 * implementation of  Heap Sort by myself
 * a kind of  unstable sort.
 *
 * @author wangpeng
 * @since 2021-04-24
 */
public class HeapSort {

    public int[] sort(int[] s) {
        int lastNonLeafIdx = (s.length - 1) / 2;
        // adjusting complete binary tree to a heap
        for (int i = lastNonLeafIdx; i > 1; i--) {
            adjustHeap(s, i, s.length - 1);
        }
        int adjustCount = s.length - 2;
        int lastIdx = s.length - 1;
        for (int i = 0; i < adjustCount; i++) {
            adjustHeap(s, 1, lastIdx);
            swap(s, 1, lastIdx--);
        }
        return s;
    }

    /**
     * @param s
     * @param rootIdx
     * @param lastIdx
     */
    private void adjustHeap(int[] s, int rootIdx, int lastIdx) {
        if (2 * rootIdx > lastIdx) return;
        int maxIdx = selectMaxIdx(s, 2 * rootIdx, 2 * rootIdx + 1 > lastIdx ? 2 * rootIdx : 2 * rootIdx + 1);
        if (s[rootIdx] < s[maxIdx]) {
            swap(s, rootIdx, maxIdx);
            adjustHeap(s, maxIdx, lastIdx);
        }
    }

    private int selectMaxIdx(int[] s, int idx1, int idx2) {
        if (s[idx1] > s[idx2]) {
            return idx1;
        }
        return idx2;
    }

    private void swap(int[] s, int idx1, int idx2) {
        // TODO we can use  bit operation OR to omit tmp variable.
        int tmp = s[idx1];
        s[idx1] = s[idx2];
        s[idx2] = tmp;
    }
}
