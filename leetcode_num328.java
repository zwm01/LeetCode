package LinkList.num328;


/*创建两个虚拟的头结点1和2，奇数节点连接到1上，偶数节点连接到2上
* 最后将2连接到1的尾部，返回1的下一个节点为头部
* 时间复杂度：O(N)
* 空间复杂度：O(1)*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode head1=new ListNode(0);
        ListNode head2=new ListNode(0);
        ListNode temp1=head1;
        ListNode temp2=head2;
        int count=1;
        while (head!=null){
            if (count%2==1){
                temp1.next=head;
                temp1=temp1.next;
            }
            else{
                temp2.next=head;
                temp2=temp2.next;
            }
            head=head.next;
            count++;
        }
        temp2.next=null;
        temp1.next=head2.next;
        head2.next=null;
        ListNode res=head1.next;
        head1.next=null;
        return res;
    }
}
