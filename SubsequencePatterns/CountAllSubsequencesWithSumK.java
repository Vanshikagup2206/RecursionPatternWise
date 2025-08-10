package RecursionPatternWise.SubsequencePatterns;

public class CountAllSubsequencesWithSumK {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return count(nums, 0, k, 0);
    }

    public int count(int[] nums, int index, int k, int currentSum){
        if(index == nums.length){
            if(currentSum == k)
                return 1;
            else
                return 0;
        }

        int include = count(nums, index + 1, k, currentSum + nums[index]);

        int exclude = count(nums, index + 1, k, currentSum);

        return include + exclude;
    }
}