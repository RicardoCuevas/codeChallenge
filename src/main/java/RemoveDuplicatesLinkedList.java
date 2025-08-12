//83. Remove Duplicates from Sorted List
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class RemoveDuplicatesLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode node = deleteDuplicates(head);
        ListNode node1 = deleteDuplicates1(head);
        ListNode node2 = deleteDuplicates2(head);
        print(node);
        print(node1);
        print(node2);
    }

    public static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            return deleteDuplicates(head);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }

    }

    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        if (slow != fast) {
            slow.next = null;
        }
        return head;
    }
}


/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */