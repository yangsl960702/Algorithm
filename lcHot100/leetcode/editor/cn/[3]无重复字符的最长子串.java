//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9372 👎 0


/**
 * 哈希表 + 双指针之滑动窗口
 * 窗口放的是当前还没有产生重复的字串
 * 当j入：
 *  不产生重复，右窗口移动，窗口变大
 *  产生重复，左窗口移动，窗口变小
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] st = new int[50010];
        int result = 0;
        for (int i = 0, j = 0; i < s.length(); i ++ ) {
            st[s.charAt(i) - ' '] ++ ;
            while (st[s.charAt(i) - ' '] > 1) {
                st[s.charAt(j) - ' '] -- ;
                j ++ ;
            }
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
