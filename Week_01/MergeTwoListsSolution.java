package Week_01;

/**
 * @author chengtong
 * @date 2020/7/24 03:23
 */
public class MergeTwoListsSolution {

    /**
     * 三个指针。如果使用传入的l1和l2作为指针，能精简代码
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode = new ListNode(-1);
        ListNode prev = listNode;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                prev.next = new ListNode(l1.val);
                prev = prev.next;
                l1 = l1.next;
            } else {
                prev.next = new ListNode(l2.val);
                prev = prev.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            prev.next = new ListNode(l2.val, l2.next);
        }

        if (l2 == null) {
            prev.next = new ListNode(l1.val, l1.next);
        }
        return listNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }


    public static void main(String[] args) {
        MergeTwoListsSolution solution = new MergeTwoListsSolution();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(4);
        ListNode s = solution.mergeTwoLists(l1, l2);

    }
}
