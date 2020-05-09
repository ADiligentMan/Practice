import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: wangpeng
 * @Date: 2020-02-26 11:11
 */
public class TwoNumSum {



    public boolean  start(int [] nums, int target){
        Arrays.sort(nums);

        int start = 0 ;
        int end = nums.length -1;
        while(start < end){
            int sum = (nums[start] + nums[end]);
            if(target < sum){
                start++;
            }else if(target < sum){
                end --;
            }else{
                return true;
            }
        }

        return false;

    }


}
