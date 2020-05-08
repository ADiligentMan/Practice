import java.util.Arrays;

/**
 * @Author: wangpeng
 * @Date: 2020-03-08 21:03
 *
 * 在数组中找两数之和(有可能是出现多对)
 *         input:
 *         int [] nums = {1,3,2,1,4,5};
 *         int k = 5;
 *         output:`
 *         1,4 2,3
 */
public class MultiTwoSum {

    public void start(int [] nums,int k){

        StringBuilder sb = new StringBuilder();
        Arrays.sort(nums);
        int l = 0;
        int h = nums.length - 1;

        while(l < h){
            int sum = (nums[l] + nums[h]);
            if( sum < k) {
                l++;
            } else if(sum > k ){
                h--;
            } else{
                sb.append(nums[l]).append(",").append(nums[h]).append(" ");
                if(nums[l] == nums[h]) return;
                int var = l;
                do{
                    var ++ ;
                }while(nums[var] == nums[l] );
                l = var;

                var = h ;
                do{
                    var -- ;
                }while(nums[var] == nums[h]);
                h = var;
            }
        }

        System.out.println(sb.toString());
    }
}
