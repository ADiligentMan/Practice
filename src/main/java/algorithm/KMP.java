package algorithm;

/**
 * @Author: wangpeng
 * @Date: 2020-05-09 12:59
 *
 * implements KMP.
 */
public class KMP {

    private int [] next;
    private String s;
    private String p;

    public KMP( String s , String p){
        this.s = s;
        this.p = p;
        next = new int[p.length()];
    }

    private void constructNext(){


    }

    /**
     * return starting Index of p if p is a substring of s or -1.
     * @return
     */
    int getStartIndex(){
        return  -1;
    }


}
