import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class phoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        helper("", res, map, digits, 0);
        return res;
    }
    void helper(String subres, List<String> res, Map<Character, String> map, String digits, int index) {
        if (index == digits.length()) {
            res.add(subres);
            return;
        }
        String item = map.get(digits.charAt(index));
        for (int i = 0; i < item.length(); i++) {
        helper(subres + item.charAt(i), res, map, digits, index + 1);
        }
    }
}