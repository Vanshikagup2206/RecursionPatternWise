package RecursionPatternWise.SubsequencePatterns;

import java.util.*;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, "", 0, 0, result);
        return result;
    }
    public void helper(int n, String current, int open, int close, List<String> result){
        if(open == n && close == n){
            result.add(current);
            return;
        }
        
        if(open < n){
            helper(n, current + "(", open + 1, close, result);
        }
        if(close < open){
            helper(n, current + ")", open, close + 1, result);
        }
    }
}