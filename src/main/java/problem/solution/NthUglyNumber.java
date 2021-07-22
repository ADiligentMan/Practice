package problem.solution;

/**
 * Leetcode 264
 *
 * @author wangpeng
 * @since 2021-04-11
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        int count = 1; // ugly number count;
        if(n == 1){
            return count;
        }
        int incNum = 2;
        int[] arr = {2, 3, 5};
        while (true) {
            int dividend = incNum;
            while (true) {
                boolean isDivisible = false;
                for (int i = 0; i < 3; i++) {
                    if (dividend % arr[i] == 0) {
                        dividend = dividend / arr[i];
                        isDivisible = true;
                        break;
                    }
                }
                if (!isDivisible){
                    break;
                }
                if (dividend == 1) {
                    count++;
                    break;
                }
            }
            if (count == n) {
                return incNum;
            }
            incNum++;
        }
    }
}
