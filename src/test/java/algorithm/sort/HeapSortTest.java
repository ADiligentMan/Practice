package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * TODO describe
 *
 * @author wangpeng
 * @since 2021-04-24
 */
public class HeapSortTest {

    @Test
    public void sort() {
        HeapSort heapSort = new HeapSort();
        int[] ints = geneRandomIntSequence();
        heapSort.sort(ints);
        System.out.println(Arrays.toString(ints));
        Assert.assertTrue(judgeCorrectness(ints));
    }

    private static int[] geneRandomIntSequence() {
        Random ran = new Random();

        int[] s = new int[20];
        s[0] = 0;
        for (int i = 1; i < s.length; i++) {
            int i1 = ran.nextInt(1000);// generate  int values in interval [0,100).
            s[i] = i1;
        }
        System.out.println(Arrays.toString(s));
        return s;
    }

    private boolean judgeCorrectness(int[] ints) {
        for (int i = 2; i < ints.length; i++) {
            if (ints[i - 1] > ints[i]) {
                return false;
            }
        }
        return true;
    }

}