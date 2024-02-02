public class QuickSort<T extends Comparable<T>> implements ISort    <T> {
    @Override
    public Node<T> sort(Node<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<T> pivot = partition(head);
        Node<T> temp = pivot;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(sort(pivot.getNext()));
        pivot.setNext(null);

        Node<T> left = sort(head);
        Node<T> right = temp.getNext();

        if (left == pivot) {
            return pivot;
        }

        temp = left;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(pivot);
        return left;
    }

    private Node<T> partition(Node<T> head) {
        Node<T> pivot = head;
        Node<T> i = head;
        Node<T> j = head.getNext();

        while (j != null) {
            if (j.getValue().compareTo(pivot.getValue()) < 0) {
                i = i.getNext();

                T temp = i.getValue();
                i.setValue(j.getValue());
                j.setValue(temp);
            }
            j = j.getNext();
        }

        T temp = i.getValue();
        i.setValue(pivot.getValue());
        pivot.setValue(temp);

        return i;
    }
}