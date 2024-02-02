public class SelectionSort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public Node<T> sort(Node<T> head) {
        Node<T> current = head;
        while (current != null) {
            Node<T> min = current;
            Node<T> r = current.getNext();

            while (r != null) {
                if (min.getValue().compareTo(r.getValue()) > 0) {
                    min = r;
                }
                r = r.getNext();
            }

            T x = current.getValue();
            current.setValue(min.getValue());
            min.setValue(x);
            current = current.getNext();
        }
        return head;
    }
}