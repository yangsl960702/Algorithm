//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6645 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 中心扩散法
 * 回文字串两种情况：
 * 当中心点为 i 时：
 * 1. 回文串长度为奇数，进行中心扩散时，起点为 i - 1, i + 1
 * 2. 回文串长度为偶数，进行中心扩散时，起点为 i - 1, i,
 *
 * 时间复杂度为O(N^2)
 *
 * 后续需要进化到O(NlogN)  再进化到O(N)
 */
class Solution {

    public String longestPalindrome(String s) {

        int l1 = 0, r1 = 0, max = 0;

        for (int i = 0; i < s.length(); i ++ ) {
            int l = i - 1, r = i + 1;
            while (0 <= l && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l -- ;
                r ++ ;
            }
            if (max < (r - 1) - (l + 1) + 1) {
                l1 = l + 1;
                r1 = r - 1;
                max = r - l - 1;
            }

            l = i - 1;
            r = i;
            while (0 <= l && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l -- ;
                r ++ ;
            }
            if (max < (r - 1) - (l + 1) + 1) {
                l1 = l + 1;
                r1 = r - 1;
                max = (r - 1) - (l + 1) + 1;
            }

        }
        return s.substring(l1, r1 + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
