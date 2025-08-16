package RecursionPatternWise.AllCombos;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int index, List<String> current, List<List<String>> result){
        // If index == s.length() we add a copy of current into result
        if(index == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

//      If it’s a palindrome we:
//      add s[index..i] to current
//      recurse with backtrack(i+1, current)
//      after recursion, remove the last element from current (backtrack)

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                current.add(s.substring(index, i + 1));

                backtrack(s, i + 1, current, result);

                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
}

/*
 * Full dry-run (every micro-step)

Start: result = [], initial call backtrack(0, []).

1) backtrack(index=0, current=[])

Loop i from 0 to 2.

i = 0

substring = s[0..0] = "a".

isPalindrome(s,0,0):

start=0, end=0 → start < end is false, so loop not entered → returns true.

Action:

current.add("a") → current = ["a"].

Recurse → backtrack(1, ["a"]).

2) backtrack(index=1, current=["a"])

Loop i from 1 to 2.

i = 1

substring = s[1..1] = "a".

isPalindrome(s,1,1):

start=1, end=1 → start < end false → returns true.

Action:

current.add("a") → current = ["a","a"].

Recurse → backtrack(2, ["a","a"]).

3) backtrack(index=2, current=["a","a"])

Loop i from 2 to 2 (only i=2).

i = 2

substring = s[2..2] = "b".

isPalindrome(s,2,2):

start=2, end=2 → start < end false → returns true.

Action:

current.add("b") → current = ["a","a","b"].

Recurse → backtrack(3, ["a","a","b"]).

4) backtrack(index=3, current=["a","a","b"])

Now index == s.length() (3), base case:

Add a copy of current to result:
result.add(new ArrayList<>(["a","a","b"]))

Now result = [["a","a","b"]].

Return to caller (backtrack(2, ["a","a"])).

Returning to step 3 (index=2):

After recursion returned, we perform backtracking:

current.remove(current.size()-1) removes "b" → current = ["a","a"].

End of loop at index=2 (i had only value 2).

Return to caller (backtrack(1, ["a"])).

Returning to step 2 (index=1), continuing loop:

After returning from backtrack(2, ["a","a"]) we removed the "b" already. Now at index=1 we continue loop.

Next i = 2

substring = s[1..2] = "ab".

isPalindrome(s,1,2):

start=1, end=2 → compare s.charAt(1) = 'a' with s.charAt(2) = 'b' → they differ → return false.

Since not palindrome → we skip add/recurse.

End loop at index=1.

Before returning, backtrack step removes last added for this frame:

We added "a" earlier at this frame, so now current.remove(...) removes that "a" → current = ["a"] → (this removal happened when we unwind from the palindrome branch that recursed earlier).

Return to caller (backtrack(0, [])).

Note: The remove of "a" happened after the palindrome branch for i=1 finished; we explicitly remove in the code right after the recursive call in that if block.

Returning to step 1 (index=0), continuing loop:

After finishing the branch for i=0, we removed the "a" that had been added at index=0 → current is now [].

Next i = 1

substring = s[0..1] = "aa".

isPalindrome(s,0,1):

start=0, end=1 → compare s.charAt(0) 'a' with s.charAt(1) 'a' → equal → increment/decrement → start=1, end=0.

Now start < end false → loop ends → return true.

Action:

current.add("aa") → current = ["aa"].

Recurse → backtrack(2, ["aa"]).

5) backtrack(index=2, current=["aa"])

Loop i from 2 to 2.

i = 2

substring = s[2..2] = "b".

isPalindrome(s,2,2) → returns true (single-char).

Action:

current.add("b") → current = ["aa","b"].

Recurse → backtrack(3, ["aa","b"]).

6) backtrack(index=3, current=["aa","b"])

index == s.length() → base case:

Add copy of current to result:
result.add(new ArrayList<>(["aa","b"]))

Now result = [["a","a","b"], ["aa","b"]].

Return to caller (backtrack(2, ["aa"])).

Returning to step 5 (index=2):

After recursion return, remove last element "b" → current = ["aa"].

Loop at index=2 ends (only i=2).

Return to caller (backtrack(0, [])).

Back at step 1 (index=0), after i=1 branch:

Remove the "aa" we added → current = [].

Next i = 2

substring = s[0..2] = "aab".

isPalindrome(s,0,2):

start=0, end=2 → compare s.charAt(0) 'a' with s.charAt(2) 'b' → differ → return false.

Not a palindrome → skip add/recurse.

Loop ends (i reached last index).

backtrack(0, []) returns to partition.

Final result

result now contains exactly:

[ ["a","a","b"], ["aa","b"] ]
 */