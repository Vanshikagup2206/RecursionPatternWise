package RecursionPatternWise.SubsequencePatterns;

public class CheckSubsequenceSum {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        return count(nums, 0, k, 0);
    }
    public boolean count(int[] nums, int index, int k, int currentSum){
        if(currentSum == k)
            return true;
            
        if(index == nums.length){
            return false;
        }

        boolean include = count(nums, index + 1, k, currentSum + nums[index]);

        boolean exclude = count(nums, index + 1, k, currentSum);

        return include || exclude;
    }
}