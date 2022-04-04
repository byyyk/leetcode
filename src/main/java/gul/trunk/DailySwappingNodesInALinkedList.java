package gul.trunk;

public class DailySwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        var nextNode = head;
        var fromBeginningPredecessor = head;
        var fromEndPredecessor = head;
        for (int i = 0; nextNode != null; i++) {
            if (i < k - 2) {
                fromBeginningPredecessor = fromBeginningPredecessor.next;
            } else if (i > k) {
                fromEndPredecessor = fromEndPredecessor.next;
            }
            nextNode = nextNode.next;
        }
        var tmp = fromEndPredecessor.next.next;
        fromEndPredecessor.next.next = fromBeginningPredecessor.next.next;
        fromBeginningPredecessor.next.next = tmp;
        fromBeginningPredecessor.next = fromEndPredecessor.next;

        fromEndPredecessor.next = fromBeginningPredecessor.next;

        if (k == 1) {
            return fromBeginningPredecessor.next;
        } else {
            return head;
        }
    }
}
