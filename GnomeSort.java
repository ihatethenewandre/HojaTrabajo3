public class GnomeSort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public Node<T> sort(Node<T> node) {
        Node<T> head = node;
        Node<T> current = node;

        while (current.getNext() != null) {
            if (current.getValue().compareTo(current.getNext().getValue()) > 0) {
                T temp = current.getValue();
                current.setValue(current.getNext().getValue());
                current.getNext().setValue(temp);

                if (current != head) {
                    current = current.getPrevious();
                }
            } else {
                current = current.getNext();
            }
        }

        return head;
    }
}