public class Solution {
    public boolean backspaceCompare(String s, String t) {
        return trim(s).equals(trim(t));
    }

    private String trim(String a) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = a.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == '#') {
                if (i > 0)
                    sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(cArr[i]);
            }
        }
        return sb.toString();
    }
}
