public interface ISort<T extends Comparable<T>> {
    Node<T> sort(Node<T> node);
}