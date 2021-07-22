package problem.solution;

/**
 * leetcode 738
 *
 * @author wangpeng
 * @since 2020-12-15
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {

        char[] digits = Integer.valueOf(N).toString().toCharArray();
        char[] resultDigits = new char[digits.length];
        resultDigits[0] = digits[0];

        int i = 1;
        while (i < digits.length) {
            if (digits[i] < resultDigits[i - 1]) {
                break;
            }
            resultDigits[i] = digits[i];
            i++;
        }

        if (i == digits.length) {
            return Integer.valueOf(String.copyValueOf(resultDigits));
        }

        int k;
        for (k = i - 1; k >= 0; k--) {
            resultDigits[k]--;
            if (k > 0 && resultDigits[k] >= resultDigits[k - 1]) {
                break;
            }
        }
        k = k == -1 ? 0 : k;
        for (int j = k + 1; j < resultDigits.length; j++) {
            resultDigits[j] = '9';
        }

        return Integer.valueOf(String.copyValueOf(resultDigits));
    }
}
