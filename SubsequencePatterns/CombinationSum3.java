package RecursionPatternWise.SubsequencePatterns;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(k, n, 1, new ArrayList<>(), result);
        
        return result;
    }

    private void backtrack(int k, int n, int num, List<Integer> current, List<List<Integer>> result){
        if(n == 0 && current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }

        if (n < 0 || num > 9 || current.size() > k) return;

        current.add(num);
        backtrack(k, n - num, num + 1, current, result);

        current.remove(current.size() - 1);
        backtrack(k, n, num + 1, current, result);
    }
}