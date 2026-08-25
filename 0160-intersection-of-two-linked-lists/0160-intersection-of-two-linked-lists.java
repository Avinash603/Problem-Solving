/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public static int length(ListNode head){
        int len=1;
        ListNode curr=head;
        while(curr!=null){
           curr=curr.next;
           len++; 
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int l1=length( headA);
        int l2=length(headB);
        ListNode c1=headA;
        ListNode c2=headB;
        while(l1!=l2){
            if(l1>l2){
                c1=c1.next;
                l1--;

            }else{
                c2=c2.next;
                l2--;
            }
        }
        while(c1!=null&& c2!=null){
            if(c1==c2){
                return c1;
            }
            c1=c1.next;
            c2=c2.next;
        }
        return null;
    }
}