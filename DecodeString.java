import java.util.*;

/**
 * 🔥【字符串解码】
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class DecodeString {

    // 栈（后进先出）
    // 递归
    public String decodeString(String s) {
        // 遇到 "]" 进行弹出栈处理
        Deque<Character> deque = new ArrayDeque<>();
        int n = s.length();

        List<Character> part = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ']') {
                part.clear();
                while (!deque.isEmpty()) {
                    char top = deque.pollLast();
                    if (top == '[') {
                        break;
                    } else {
                        part.add(top);
                    }
                }
                int cnt = 0;
                int w = 1;
                while (!deque.isEmpty()) {
                    char top = deque.getLast();
                    if (Character.isDigit(top)) {
                        top = deque.pollLast();
                        int digit = Integer.parseInt(top + "");
                        cnt = w * digit + cnt;
                        w *= 10;
                    } else {
                        break;
                    }
                }
                for (int j = 0; j < cnt; j++) {
                    for (int k = part.size() - 1; k >= 0; k--) {
                        deque.addLast(part.get(k));
                    }
                }
            } else {
                deque.addLast(s.charAt(i));
            }
            i++;
        }

        int size = deque.size();
        char[] resChars = new char[size];
        i = 0;
        while (i < size && !deque.isEmpty()) {
            resChars[i] = deque.pollFirst();
            i++;
        }
        return String.valueOf(resChars);
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String s = "3[a]2[bc]";
        String decode = ds.decodeString(s);
        System.out.println(decode);

        s = "3[a2[c]]";
        decode = ds.decodeString(s);
        System.out.println(decode);

        s = "2[abc]3[cd]ef";
        decode = ds.decodeString(s);
        System.out.println(decode);

        s = "abc3[cd]xyz";
        decode = ds.decodeString(s);
        System.out.println(decode);

        s = "3[a12[c]]";
        decode = ds.decodeString(s);
        System.out.println(decode);
    }
}
