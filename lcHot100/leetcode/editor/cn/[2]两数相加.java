//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 9793 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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

/**
 * 思路： 高精度加法的链表形式
 * 1. 用n, m记录哪个链表长，以便知道最后应该返回哪个
 * 2. 用r1, r2记录两个链表的最后一位，以便当高精度进位t最后仍然是1，知道该插到哪里
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int t = 0;
       ListNode head1 = l1;
       ListNode head2 = l2;
       ListNode r1 = new ListNode();
       ListNode r2 = new ListNode();
       int n = 0, m = 0;

       while(head1 != null || head2 != null) {
           if (head1 != null) {
               t += head1.val;
               r1 = head1;
               n ++ ;
           }
           if (head2 != null) {
               t += head2.val;
               r2 = head2;
               m ++ ;
           }
           if (head1 != null) {
               head1.val = t % 10;
               head1 = head1.next;
           }
           if (head2 != null) {
               head2.val = t % 10;
               head2 = head2.next;
           }
           t /= 10;
       }
       if (t != 0) {
           if (n > m) r1.next = new ListNode(t);
           else r2.next = new ListNode(t);
       }
       return n > m ? l1 : l2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
