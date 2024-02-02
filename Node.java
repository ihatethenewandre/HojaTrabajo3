public class Node<T> {
    T value;

    Node<T> next;
    Node<T> previous;

    public Node (T value) {
        this.value = value;

        next = null;
        previous = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}