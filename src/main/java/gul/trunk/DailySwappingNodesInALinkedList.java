package gul.trunk;

public class DailySwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }
        var nextNode = head;
        var fromBeginningPredecessor = head;
        var fromEndPredecessor = head;

        int size = 0;
        for (int i = 0; nextNode != null; i++) {
            size++;

            if (i < k - 2) {
                fromBeginningPredecessor = fromBeginningPredecessor.next;
            } else if (i > k) {
                fromEndPredecessor = fromEndPredecessor.next;
            }
            nextNode = nextNode.next;
        }
        if (size == 2 && k == 2) {
            k = 1;
        }
        var fromEndSuccessor = fromEndPredecessor.next.next;
        var fromEnd = fromEndPredecessor.next;

        ListNode fromBeginning = null;
        if (k == 1) {
            fromBeginning = fromBeginningPredecessor;
            fromBeginningPredecessor = null;
        } else {
            fromBeginning = fromBeginningPredecessor.next;
        }
        var fromBeginningSuccessor = fromBeginning.next;

        if (fromBeginning.next == fromEnd) {
            fromEnd.next = fromBeginning;
            fromBeginning.next = fromEndSuccessor;
            if (k != 1) {
                fromBeginningPredecessor.next = fromEnd;
            }
        } else if (fromEnd.next == fromBeginning) {
            fromEnd.next = fromBeginningSuccessor;
            fromBeginning.next = fromEnd;
            fromEndPredecessor.next = fromBeginning;
        } else {
            fromEnd.next = fromBeginningSuccessor;
            fromBeginning.next = fromEndSuccessor;
            fromEndPredecessor.next = fromBeginning;
            if (k != 1) {
                fromBeginningPredecessor.next = fromEnd;
            }
        }

        if (k == 1) {
            return fromEnd;
        } else {
            return head;
        }
    }
}
