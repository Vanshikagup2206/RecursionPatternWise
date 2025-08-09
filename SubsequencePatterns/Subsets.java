package RecursionPatternWise.SubsequencePatterns;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subset(nums, 0, current, result);
        return result;
    }

    public void subset(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include current element
        current.add(nums[index]);
        subset(nums, index + 1, current, result);

        // Backtrack (remove last added element)
        current.remove(current.size() - 1);

        // Exclude current element
        subset(nums, index + 1, current, result);
    }
}