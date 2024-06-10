import java.util.*;

/**
 * 【电话号码的字母组合】
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 */
public class LetterCombinations {

    // 哈希表
    // 字符串
    // 回溯
    // 队列
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (Objects.isNull(digits) || digits.isEmpty()) {
            return ans;
        }

        Map<Character, String> dic = new HashMap<>();
        init(dic);

        backtrack(ans, dic, digits, 0, new StringBuffer());

        return ans;
    }

    // 队列
    public List<String> letterCombinations2(String digits) {
        List<String> ans = new ArrayList<>();
        if (Objects.isNull(digits) || digits.isEmpty()) {
            return ans;
        }

        Map<Character, String> dic = new HashMap<>();
        init(dic);

        Deque<String> q = new ArrayDeque<>();
        int i = 0;
        while (i < digits.length()) {
            String letters = dic.get(digits.charAt(i));
            if (q.isEmpty()) {
                for (char c : letters.toCharArray()) {
                    q.addLast(String.valueOf(c));
                }
            } else {
                List<String> row = new ArrayList<>();
                while (!q.isEmpty()) {
                    String top = q.pollFirst();
                    for (char c : letters.toCharArray()) {
                        row.add(top + c);
                    }
                }
                for (String r : row) {
                    q.addLast(r);
                }
            }
            i++;
        }

        while (!q.isEmpty()) {
            String top = q.pollFirst();
            ans.add(top);
        }

        return ans;
    }

    private void init(Map<Character, String> dic) {
        dic.put('2', "abc");
        dic.put('3', "def");
        dic.put('4', "ghi");
        dic.put('5', "jkl");
        dic.put('6', "mno");
        dic.put('7', "pqrs");
        dic.put('8', "tuv");
        dic.put('9', "wxyz");
    }

    /*
     * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。
     * 该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面，
     * 然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。然后进行回退操作，遍历其余的字母排列。
     *
     * 回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。
     * 在这道题中，由于每个数字对应的每个字母都可能进入字母组合，因此不存在不可行的解，直接穷举所有的解即可。
     */

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        String digits = "23";
        List<String> ans = lc.letterCombinations2(digits);
        System.out.println(ans);
    }
}
