import java.util.*;

//234. Palindrome Linked List
//https://leetcode.com/problems/palindrome-linked-list/submissions/1710356583/
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        //head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
        //System.out.println(isPalindromeOptimalSolution(head)); TODO Pending optimal solution
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = reverseList(slow);
        ListNode left = head;
        while(right!=null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode node){
        if(node==null) return node;

        ListNode previous = null;
        ListNode current = node;
        ListNode next = node.next;

        while(current!=null){
            current.next = previous;
            previous = current;
            current = next;
            if(next!=null){
                next = next.next;
            }
        }
        return previous;
    }

    public static boolean isPalindromeOptimalSolution(ListNode head) {
        ListNode dummyNode = head;
        if(head==null) return false;
        if(head.next == null) return true;
        List<Integer> list = new ArrayList<>();

        while(dummyNode!=null){
            list.add(dummyNode.val);
            dummyNode = dummyNode.next;
        }
        System.out.println("head.val = " + head.val);
        list.stream().forEach(val -> System.out.print(val+" "));
        System.out.println();
        int left = 0;
        int right = list.size()-1;
        while (left<=right){
            System.out.println("list.get(left) = " + list.get(left));
            System.out.println("list.get(right) = " + list.get(right));
            if(list.get(left)!=list.get(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 *
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */