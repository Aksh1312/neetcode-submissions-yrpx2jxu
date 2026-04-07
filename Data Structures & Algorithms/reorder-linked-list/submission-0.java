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
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr=slow.next;
        slow.next=null;
        ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode p2=prev;
        ListNode p1=head;
        while(p2!=null){
            ListNode n1=p1.next,n2=p2.next;
            p1.next=p2;
            p2.next=n1;
            p1=n1;
            p2=n2;
        }
    }
}
