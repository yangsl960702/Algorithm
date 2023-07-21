//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2611 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 非常基础的DFS
 */
class Solution {

    public static List<List<Integer>> result = new ArrayList<>();
    public static List<Integer> list = new ArrayList<>();

    public void dfs(int x, int[] nums, boolean[] st) {
        if (x == nums.length) {
            List<Integer> mid = new ArrayList<>();
            for (int i= 0; i < list.size(); i ++ ) mid.add(list.get(i));
            result.add(mid);
        }

        for (int i = 0; i < nums.length; i ++ ) {
            if (!st[i]) {
                st[i] = true;
                list.add(nums[i]);

                dfs(x + 1, nums, st);

                st[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        list.clear();
        result.clear();
        int n = nums.length;
        boolean[] st = new boolean[n];
        Arrays.sort(nums);

        dfs(0, nums, st);

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
