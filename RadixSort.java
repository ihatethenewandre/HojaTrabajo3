public class RadixSort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public Node<T> sort(Node<T> head) {
        // Radix Sort solo funciona con números enteros, por lo que necesitamos convertir los datos a enteros.
        int max = findMaxValue(head);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            head = countSort(head, exp);
        }
        return head;
    }

    private Node<T> countSort(Node<T> head, int exp) {
        Node<T>[] output = new Node[10];
        int[] count = new int[10];

        Node<T> current = head;
        while (current != null) {
            count[((Integer) current.getValue() / exp) % 10]++;
            current = current.getNext();
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        current = head;
        while (current != null) {
            output[count[((Integer) current.getValue() / exp) % 10] - 1] = current;
            current = current.getNext();
            count[((Integer) output[count[((Integer) current.getValue() / exp) % 10] - 1].getValue() / exp) % 10]--;
        }

        for (int i = 0; i < output.length; i++) {
            if (output[i] != null) {
                return output[i];
            }
        }

        return null;
    }

    private int findMaxValue(Node<T> head) {
        int max = Integer.MIN_VALUE;
        Node<T> current = head;
        while (current != null) {
            max = Math.max(max, (Integer) current.getValue());
            current = current.getNext();
        }
        return max;
    }
}