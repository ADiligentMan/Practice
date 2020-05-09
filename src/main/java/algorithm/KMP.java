package algorithm;

/**
 * @Author: wangpeng
 * @Date: 2020-05-09 12:59
 * <p>
 * implements KMP.
 */
public class KMP {

    private int[] next;
    private String s;
    private String p;

    public KMP(String s, String p) {
        this.s = s;
        this.p = p;
        next = new int[p.length()];
        constructNext();
    }

    private void constructNext() {
//        next[0] = -1;
//        next[1] = 0;
//        for (int i = 2, length = next.length; i < length; i++) {
//
//            int backj = next[i - 1];
//            while (-1 != backj) {
//                if (p.charAt(i - 1) == p.charAt(backj)) {
//                    next[i] = next[i - 1] + 1;
//                    break;
//                }else{
//                    backj = next[backj];
//                }
//            }
//            if(backj == -1){
//                next[i] = 0;
//            }
//        }

        int j = 0, k = -1;
        next[0] = -1;
        int len = p.length();
        while (j < len - 1) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
    }

    /**
     * return starting Index of p if p is a substring of s, or -1.
     *
     * @return
     */
    int getStartIndex() {
        int i = 0;
        int j = 0;
        int sLength = s.length();
        int pLength = p.length();
        while (i < sLength && j < pLength) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;

            } else {
                j = next[j];
            }
        }
        if (j == pLength) {
            return i - pLength;
        }
        return -1;
    }

    /**
     * calculate how many times p appears in s.
     * @return
     */
    int count() {
        int i = 0;
        int j ;
        int sLength = s.length();
        int pLength = p.length();
        int number = 0;
        do {
            j = 0;
            while (i < sLength && j < pLength) {
                if (j == -1 || s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;

                } else {
                    j = next[j];
                }
            }

            if (j == pLength) {
                 number++;
            }
        } while (sLength - i > pLength);

        return number;
    }

    public static void main(String[] args) {
        String s = "sfewfewfwfeee";
        String p = "wfe";
        System.out.println(new KMP(s,p).count());
    }
}
