package RecursionPatternWise.AllCombos;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0)
            return true;
        
        if(board.length == 0 || board[0].length == 0)
            return false;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }  

        return false;  
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int wordIndex){
        if(wordIndex == word.length()){
            return true;
        }

        //Out-of-bounds check
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }

        //Character mismatch check
        if(board[row][col] != word.charAt(wordIndex)){
            return false;
        }

        // Mark this cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore in all 4 directions
        boolean found =
            backtrack(board, word, row - 1, col, wordIndex + 1) || // up
            backtrack(board, word, row + 1, col, wordIndex + 1) || // down
            backtrack(board, word, row, col - 1, wordIndex + 1) || // left
            backtrack(board, word, row, col + 1, wordIndex + 1);   // right

        // Restore the cell after exploration
        board[row][col] = temp;

        return found;
    }
}

/*
 * full step-by-step dry run of Word Search with your fixed code, just like we did for palindrome partition.

We’ll use the example:

board = [
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED"

Step 0: Initial call

exist(board, "ABCCED") → loops over every cell.

Start with (0,0) because board[0][0] = 'A' which matches word[0] = 'A'.

Call backtrack(board, "ABCCED", 0, 0, 0).

Step 1: backtrack(0,0,0)

wordIndex = 0, board[0][0] = 'A' → matches word[0] = 'A' ✅

Mark visited: board[0][0] = '#'

Explore neighbors with wordIndex + 1 = 1

Neighbors:

Up: (-1,0) → out of bounds → return false

Down: (1,0) → board[1][0] = 'S' ≠ word[1]='B' → return false

Left: (0,-1) → out of bounds → return false

Right: (0,1) → board[0][1]='B' = word[1]='B' ✅

Move to (0,1) next

Step 2: backtrack(0,1,1)

wordIndex=1, board[0][1]='B' → matches word[1]='B' ✅

Mark visited: board[0][1]='#'

Explore neighbors with wordIndex=2 (word[2]='C')

Neighbors:

Up: (-1,1) → out of bounds → false

Down: (1,1) → board[1][1]='F' ≠ 'C' → false

Left: (0,0) → board[0][0]='#' (visited) → cannot use → false

Right: (0,2) → board[0][2]='C' = word[2]='C' ✅

Move to (0,2) next

Step 3: backtrack(0,2,2)

wordIndex=2, board[0][2]='C' → matches word[2]='C' ✅

Mark visited: board[0][2]='#'

Explore neighbors with wordIndex=3 (word[3]='C')

Neighbors:

Up: (-1,2) → out of bounds → false

Down: (1,2) → board[1][2]='C' = word[3]='C' ✅

Move to (1,2) next

Step 4: backtrack(1,2,3)

wordIndex=3, board[1][2]='C' → matches word[3]='C' ✅

Mark visited: board[1][2]='#'

Explore neighbors with wordIndex=4 (word[4]='E')

Neighbors:

Up: (0,2) → '#' (visited) → cannot use → false

Down: (2,2) → board[2][2]='E' = word[4]='E' ✅

Move to (2,2) next

Step 5: backtrack(2,2,4)

wordIndex=4, board[2][2]='E' → matches word[4]='E' ✅

Mark visited: board[2][2]='#'

Explore neighbors with wordIndex=5 (word[5]='D')

Neighbors:

Up: (1,2) → '#' (visited) → cannot use → false

Down: (3,2) → out of bounds → false

Left: (2,1) → board[2][1]='D' = word[5]='D' ✅

Move to (2,1) next

Step 6: backtrack(2,1,5)

wordIndex=5, board[2][1]='D' → matches word[5]='D' ✅

Mark visited: board[2][1]='#'

Explore neighbors with wordIndex=6 (wordIndex == word.length)

Base case:

wordIndex == word.length() → success, return true

Step 7: Unwinding (backtracking)

Each recursive call returns true up the stack

Cells are restored as the recursion unwinds (board[row][col] = original)

Final exist() returns true

✅ Result
Output: true


The path found: (0,0)->(0,1)->(0,2)->(1,2)->(2,2)->(2,1) → "ABCCED"

All cells are used once per path

Backtracking ensures other paths could be explored if needed
 */