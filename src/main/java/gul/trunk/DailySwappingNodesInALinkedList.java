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
        for (int i = 1; nextNode != null; i++) {
            size++;

            if (i < k - 1) {
                fromBeginningPredecessor = fromBeginningPredecessor.next;
            } else if (i > k + 1) {
                fromEndPredecessor = fromEndPredecessor.next;
            }
            nextNode = nextNode.next;
        }

        if (size == 2 && k == 2) {
            k = 1;
        }
        if (k == size) {
            k = 1;
            var tmp = fromEndPredecessor;
            fromEndPredecessor = fromBeginningPredecessor;
            fromBeginningPredecessor = tmp;
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
            if (k != 1 && k != size) {
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
            if (k != 1 && k != size) {
                fromBeginningPredecessor.next = fromEnd;
            }
        }

        if (k == 1 || k == size) {
            return fromEnd;
        } else {
            return head;
        }
    }
}
