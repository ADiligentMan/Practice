import java.sql.SQLOutput;

/**
 * @Author: wangpeng
 * @Date: 2020-03-08 19:58
 *
 * 完全因式分解，并且小因子在前
 * input :
 * n = 24
 * output :
 * 2*2*2*3=24
 *
 */
public class Factoring {

    public String getResult(int n){
        if(n < 1  || n > 1000000){
            throw new IllegalArgumentException(" n is wrong.");
        }

        int initialN = n ;
        StringBuilder sb = new StringBuilder();
        for( int i = 2 ; i <=  n ; i++ ){
            while(n%i == 0){
                sb.append(i).append("*");
                n = n/i;
            }
        }

        return sb.deleteCharAt(sb.length() - 1).append("=").append(initialN).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Factoring().getResult(24));
    }
}
