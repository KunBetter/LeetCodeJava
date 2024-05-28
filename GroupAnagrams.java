import java.util.*;

/**
 * 字母异位词分组
 */
public class GroupAnagrams {

    // 数组、哈希、字符串
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> dic = new HashMap<>();

        for (String str : strs) {
            byte[] bytes = str.getBytes();
            Arrays.sort(bytes);

            String newStr = new String(bytes);

            if (!dic.containsKey(newStr)) {
                dic.put(newStr, new ArrayList<>());
            }
            dic.get(newStr).add(str);
        }

        for (Map.Entry<String, List<String>> entry : dic.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = GroupAnagrams.groupAnagrams(strs);
        System.out.println(res);
    }
}
