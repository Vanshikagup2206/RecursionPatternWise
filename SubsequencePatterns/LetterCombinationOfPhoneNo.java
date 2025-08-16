package RecursionPatternWise.SubsequencePatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationOfPhoneNo {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();

        HashMap<Character, String> combinations = new HashMap<>();
        combinations.put('2', "abc");
        combinations.put('3', "def");
        combinations.put('4', "ghi");
        combinations.put('5', "jkl");
        combinations.put('6', "mno");
        combinations.put('7', "pqrs");
        combinations.put('8', "tuv");
        combinations.put('9', "wxyz");

        List<String> result = new ArrayList<>();

        backtrack(digits, 0, new StringBuilder(), combinations, result);

        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, HashMap<Character, String> combinations, List<String> result){
        if(index == digits.length()){
            result.add(path.toString());
            return;
        }

        char currentDigit = digits.charAt(index);
        String letters = combinations.get(currentDigit);

        for(int i = 0; i < letters.length(); i++){
            path.append(letters.charAt(i));
            backtrack(digits, index + 1, path, combinations, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}