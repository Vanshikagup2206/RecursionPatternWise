package RecursionPatternWise.SubsequencePatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Step 1: Sort to make duplicate skipping possible and enable early stopping
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        
        // Step 2: Start backtracking from index 0 with empty 'current' combination
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        
        return result;
    }

    private void backtrack(int[] candidates, int target, int pos, List<Integer> current, List<List<Integer>> result) {
        // Base case 1: If target is exactly 0, we found a valid combination
        if (target == 0) {
            // Add a copy of current list (avoid reference issue)
            result.add(new ArrayList<>(current));
            return; // Stop exploring further in this path
        }

        // Base case 2: If target is negative or we reached end of array → stop
        if (target < 0 || pos == candidates.length) {
            return;
        }

        // Loop over choices starting from 'pos'
        for (int i = pos; i < candidates.length; i++) {

            // Skip duplicates: if current value is same as previous value at same level
            if (i > pos && candidates[i] == candidates[i - 1]) {
                continue; // Move to next number
            }

            // Optimization: If current number is greater than target, no need to continue
            // (because array is sorted, all later numbers will be even bigger)
            if (candidates[i] > target) {
                break; // Exit loop early
            }

            // Choose the current number
            current.add(candidates[i]);

            // Explore further: move to next index (i + 1) because each number can be used once
            backtrack(candidates, target - candidates[i], i + 1, current, result);

            // Undo the choice (backtrack) to try the next candidate
            current.remove(current.size() - 1);
        }
    }
}