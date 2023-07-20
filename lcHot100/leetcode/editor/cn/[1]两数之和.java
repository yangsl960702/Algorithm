//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics 数组 哈希表 👍 17340 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        /**
         * 暴力做法：O(N^2)
         * 先固定i，然后从i - nums.length - 1寻找，这个过程是O(N)
         * 所以可以考虑这一步怎么优化
         */
        /*for (int i = 0; i < nums.length - 1; i ++ ) {
            for (int j = i + 1; j < nums.length; j ++ ) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }*/

        /**
         * 优化过程：
         * 遍历到j时，可以去找target - nums[j] 是否已经存在
         * 如果存在直接取出返回，不存在将它放到map中去。
         * 这样做就将第二步的时间复杂度从O(N)变成了O(10，整体复杂度就变成了O(N)
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            } else
                map.put(nums[i], i);
            }
            return null;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
