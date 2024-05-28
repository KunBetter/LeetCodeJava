import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class KuoHaoIsValid {

    // 堆栈
    public boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }

        Deque<Byte> stack = new ArrayDeque<>();

        int i = 0;
        while (i < s.length()) {
            if (stack.isEmpty()) {
                stack.addLast(s.getBytes()[i]);
            } else {
                byte top = stack.getLast();
                byte cur = s.getBytes()[i];

                if (isMatch(top, cur)) {
                    stack.pollLast();
                } else {
                    stack.addLast(s.getBytes()[i]);
                }
            }

            i++;
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    private boolean isMatch(byte a, byte b) {
        if (a == '(' && b == ')') {
            return true;
        } else if (a == '[' && b == ']') {
            return true;
        } else if (a == '{' && b == '}') {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        KuoHaoIsValid kh = new KuoHaoIsValid();
        String s = "()";
        boolean flag = kh.isValid(s);
        System.out.println(flag);

        s = "()[]{}";
        flag = kh.isValid(s);
        System.out.println(flag);

        s = "(]";
        flag = kh.isValid(s);
        System.out.println(flag);

        s = "(){}}{";
        flag = kh.isValid(s);
        System.out.println(flag);
    }
}
