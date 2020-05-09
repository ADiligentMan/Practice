import sun.jvmstat.monitor.Monitor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author: wangpeng
 * @Date: 2020-03-03 21:19
 */
public class StockLine {

    public static void main(String[] args) {
        int [] stockline = new int []{66, 54, 68, 30, 88, 84, 72, 57, 83, 38};
//        for(int i = 0; i < 10 ; i++){
//            Random r = new Random();
//            stockline[i] = r.nextInt(100)+1;
//        }

        System.out.println(Arrays.toString(stockline));
        new StockLine().start(stockline);

    }

    public void start(int [] stockline){
        Quadruple q = new Quadruple();
        q.max = q.min = stockline[0];
        q.maxi = q.mini = 0;
        int diff = 0;
        int sellI = 0;
        int buyI = 0;
        for(int i = 1 ; i < stockline.length ;i++){
            if(stockline[i] > q.max) {
                q.max = stockline[i];
                q.maxi = i;
            }else if(stockline[i] < q.min){
                if(diff < q.getDiff()){
                    diff = q.getDiff();
                    sellI = q.maxi;
                    buyI = q.mini;
                }
                q.max = q.min = stockline[i];
                q.maxi = q.mini = i;
            }
        }

        if(diff < q.getDiff()){
            diff = q.getDiff();
            sellI = q.maxi;
            buyI = q.mini;
        }

        System.out.println("["+buyI+","+sellI+"] = "+diff);
    }

    private class Quadruple{
        int min;
        int max;
        int mini;
        int maxi;
        int getDiff(){
            return max - min;
        }
    }


}
