package problem.solution;

/**
 *
 * leetcode 1365
 * @author wangpeng
 * @since 2020-10-27
 */
public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] indices = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indices[i]=i;
        }
        bubbleSort(nums, indices);

        int [] results = new int[nums.length];
        int prev = 0;
        for(int i = 0; i < indices.length; i++){
            if( i != 0 && nums[i] != nums[i-1]){
                prev = i;
            }
            results[indices[i]] =prev ;
        }
        return results;
    }

    private void bubbleSort(int[] nums, int[] indices){
        for(int i = nums.length - 1; i > 0; i--){
            for(int j  = 1; j <= i; j++){
                if(nums[j] < nums[j - 1]){
                    swap(nums,j-1,j);
                    swap(indices,j-1,j);
                }
            }
        }
    }

    private void swap(int arr[], int idx1, int idx2){
        int  tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
