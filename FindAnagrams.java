import java.util.*;

/**
 * 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）
 */
public class FindAnagrams {

    // 哈希表、字符串、滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        List<Integer> ans = new ArrayList<>();

        if (sLen < pLen) {
            return ans;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // 在滑动中维护窗口中每种字母的数量
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindAnagrams fa = new FindAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> idx = fa.findAnagrams(s, p);
        System.out.println(idx);

        s = "abab";
        p = "ab";
        idx = fa.findAnagrams(s, p);
        System.out.println(idx);
    }
}
