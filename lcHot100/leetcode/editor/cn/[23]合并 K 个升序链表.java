//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2495 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /**
         * 自己的代码：
         * 1.用一个i标记当前最小点的位置
         * 2.用一个n标记当前还有多个链表没空
         */
        int n = lists.length;
        ListNode head = new ListNode();
        ListNode mid = head;
        while (n > 1) {
            int tag = -1;
            for (int i = 0; i < lists.length; i ++ ) {
                while (i < lists.length && tag == -1 && lists[i] == null) i ++ ;
                if (i < lists.length && tag == -1) tag = i;
                if (i < lists.length && lists[i] != null && lists[i].val < lists[tag].val) tag = i;
            }
            if (tag == -1) return head.next;
            mid.next = lists[tag];
            mid = mid.next;
            lists[tag] = lists[tag].next;
            if (lists[tag] == null) n -- ;
        }
        for (int i = 0; i < lists.length; i ++ ) {
            if (lists[i] != null) {
                mid.next = lists[i];
                break;
            }
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
