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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr=head;
        while(curr!=null&&curr.next!=null){
            ListNode next=curr.next;
            int val=gcd(curr.val,next.val);
            ListNode node=new ListNode(val);
            node.next=next;
            curr.next=node;
            curr=next;
        }
        return head;
    }
    public int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}