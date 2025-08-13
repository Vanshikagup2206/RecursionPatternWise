package RecursionPatternWise.SubsequencePatterns;

import java.util.ArrayList;
import java.util.List;

// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> current = new ArrayList<>();
//         list(candidates, target, 0, 0, current, result);
//         return result;
//     }
//     public void list(int[] candidates, int target, int pos, int sum, List<Integer> current, List<List<Integer>> result){
//         if(sum == target){
//             result.add(new ArrayList<>(current));
//             return;
//         }

//         if(sum > target){
//             return;
//         }

//         if(pos == candidates.length)
//             return;

//         current.add(candidates[pos]);
//         list(candidates, target, pos, sum + candidates[pos], current, result);

//         current.remove(current.size() - 1);

//         list(candidates, target, pos + 1, sum, current, result);
//     }
// }

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int pos, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || pos == candidates.length) {
            return;
        }

        // Include current number
        current.add(candidates[pos]);
        backtrack(candidates, target - candidates[pos], pos, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Skip current number
        backtrack(candidates, target, pos + 1, current, result);
    }
}
