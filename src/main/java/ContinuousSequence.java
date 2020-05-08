import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wangpeng
 * @Date: 2020-03-09 23:42
 * 找出连续的数字的和为输入值
 * input : 9
 * output : {{2,3,4},{4,5}}
 */
public class ContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> container = new LinkedList<>();
        int maxM = (int)Math.sqrt(2*target)+1;
        int actulMaxM = 0 ;
        for(int m = maxM ; m > 1 ; m-- ){
            int n = -1;
            if((n =isEqualTarget(target,m)) != -1){
                actulMaxM = Math.max(actulMaxM,m);

                List<Integer> list = new LinkedList<>();
                for(int i = 0; i<m ; i++){
                    list.add(n++);
                }
                container.add(list);
            }
        }

        int [][] arrs = new int[container.size()][];
        for(int i = 0 ; i < container.size() ; i++){
            List<Integer> list = container.get(i);
            arrs[i] = new int[list.size()];
            for(int j = 0; j < list.size() ; j++){
                arrs[i][j] = list.get(j);
            }
        }

        return arrs;

    }

    private int isEqualTarget(int target ,int m){
        int n = (2*target + m - m*m)/m ;
        int doubleSum = (n+n+m-1)*m;
        n = n/2;
        if(doubleSum == 2* target){
            if(n != 0){
                return  n;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        new ContinuousSequence().findContinuousSequence(9);
    }

}
