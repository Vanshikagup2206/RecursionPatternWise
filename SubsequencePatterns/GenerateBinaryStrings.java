package RecursionPatternWise.SubsequencePatterns;

import java.util.*;

public class GenerateBinaryStrings {
    public List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0)
            return result;
        helper(n, "", result);
        return result;
    }
    public void helper(int n, String current, List<String> result){
        if(current.length() == n){
            result.add(current);
            return;
        }
        
        if(current.length() < n){
            if(current.isEmpty() || current.charAt(current.length() - 1) == '0'){
                helper(n, current + "0", result);
                helper(n, current + "1", result);
            }else{
                helper(n, current + "0", result);
            }
        }
    }
}