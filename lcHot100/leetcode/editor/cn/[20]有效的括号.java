//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4023 👎 0


import java.util.Stack;

/**
 * 栈的基本用法
 * 本题亮点：
 * Math.abs(s.charAt(i) - st.peek()) > 2即可知道是非法匹配
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i ++ ) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                st.add(s.charAt(i));
            }else {
                if (st.size() > 0 && Math.abs(s.charAt(i) - st.peek()) > 2) {
                    return false;
                }
                if (st.size() == 0) return false;
                st.pop();
            }
        }
        if (st.size() != 0) return false;
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
