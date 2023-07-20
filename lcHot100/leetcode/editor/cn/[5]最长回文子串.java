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
class Solution {

    public String longestPalindrome(String s) {
        String sn = " " + s;
        int n = s.length();
        boolean[][] f = new boolean[n + 1][n + 1];
        int l = 1, r = 1, max = 0;

        for (int i = 1; i <= n; i ++ ) {
            for (int j = 1; j <= n; j ++ ) {
                if (i == j) f[i][j] = true;
            }
        }

        for (int i = 1; i <= n; i ++ ) {
            for (int j = i; j <= n; j ++ ) {
                System.out.println(j);
                if (sn.charAt(i) == sn.charAt(j) && (i + 1 > j - 1 || f[i + 1][j - 1] == true)) {
                    f[i][j] = true;
                    if (max < j - i + 1) {
                        l = i;
                        r = j;
                        max = Math.max(max, r - l + 1);
                    }
                }
            }
        }
        System.out.println(l + " " + r);
            return sn.substring(l, r + 1);


    }
}
//leetcode submit region end(Prohibit modification and deletion)
