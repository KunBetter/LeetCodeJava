import java.util.Arrays;

/**
 * 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。
 * 返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class MinWindow {

    // 哈希表
    // 字符串
    // 滑动窗口
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        int[] dic = new int[256];
        Arrays.fill(dic, 0);

        for (int i = 0; i < t.length(); i++) {
            dic[t.charAt(i)]--;
        }

        int cnt = 0;
        int left = 0;
        int right = 0;

        String res = "";

        while (right < s.length()) {
            if (dic[s.charAt(right)] < 0) {
                cnt++;
            }
            dic[s.charAt(right)]++;
            while (cnt == t.length()) {
                if (res.isEmpty() || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                }
                // 🔥只有t中的字符计数器为0
                // 要删除的字符在t中时，模板计数器减1
                if (dic[s.charAt(left)] == 0) {
                    cnt--;
                }
                // 🔥t中的字符计数器会变为负数，非t中的字符计数器会归0
                dic[s.charAt(left)]--;
                left++;
            }

            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        MinWindow mw = new MinWindow();
        String s = "ADOBECODEBANC", t = "ABC";
        String res = mw.minWindow(s, t);
        System.out.println(res);
    }
}
