public class MergeSort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public Node<T> sort(Node<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<T> middle = getMiddle(head);
        Node<T> nextOfMiddle = middle.getNext();

        middle.setNext(null);

        Node<T> left = sort(head);
        Node<T> right = sort(nextOfMiddle);

        Node<T> sortedList = sortedMerge(left, right);
        return sortedList;
    }

    private Node<T> sortedMerge(Node<T> a, Node<T> b) {
        Node<T> result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.getValue().compareTo(b.getValue()) <= 0) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b));
        } else {
            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
        }
        return result;
    }

    private Node<T> getMiddle(Node<T> head) {
        if (head == null) {
            return head;
        }
        Node<T> slow = head, fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
}