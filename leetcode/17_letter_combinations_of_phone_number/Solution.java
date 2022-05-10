import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    List<String> sol = new ArrayList<>();
    Map<Integer, String> map = Map.of(
            2, "abc", 3, "def", 4, "ghi", 5, "jkl", 6, "mno", 7, "pqrs", 8, "tuv", 9, "wxyz");
    String phnDigits;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return sol;
        phnDigits = digits;
        backtrack(0, new StringBuilder());
        return sol;
    }

    private void backtrack(int index, StringBuilder path) {
        if (path.length() == phnDigits.length()) {
            sol.add(path.toString());
            return;
        }
        String letters = map.get(phnDigits.charAt(index));
        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(++index, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
