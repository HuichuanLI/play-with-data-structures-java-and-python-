//leetcode 203
//link :https://leetcode.com/problems/remove-linked-list-elements/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val == val){
//            ListNode delnode = head;
            head = head.next;
//            delnode.next = null;

        }
        if(head ==null )
            return  null;
        ListNode prev = head;
        while (prev.next!= null){
            if(prev.next.val == val){
               ListNode delnode = prev.next;
                prev.next=delnode.next;
//                delnode.next = null;
            }else{
                prev = prev.next;
            }
        }
        return  head;
    }
}
// 递归的方式实现 删除重复元素

class Solution2{
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return  null;
        }
        ListNode res = removeElements(head.next,val);
        if(head.val == val){
            return res;
        }else{
            head.next = res;
            return head;
        }
    }
}