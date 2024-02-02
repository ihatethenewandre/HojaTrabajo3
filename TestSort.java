import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestSort {
    private Node<Integer> unsortedList;
    private Node<Integer> sortedList;

    @BeforeEach
    public void setUp() {
        // Crea una lista no ordenada y una lista ordenada para usar en las pruebas
        unsortedList = new Node<>(3);
        unsortedList.setNext(new Node<>(2));
        unsortedList.getNext().setNext(new Node<>(1));

        sortedList = new Node<>(1);
        sortedList.setNext(new Node<>(2));
        sortedList.getNext().setNext(new Node<>(3));
    }

    @Test
    public void testMergeSort() {
        ISort<Integer> mergeSort = new MergeSort<>();
        Node<Integer> result = mergeSort.sort(unsortedList);
        assertTrue(isEqual(result, sortedList), "MergeSort no ordenó la lista correctamente");
    }

    @Test
    public void testSelectionSort() {
        ISort<Integer> selectionSort = new SelectionSort<>();
        Node<Integer> result = selectionSort.sort(unsortedList);
        assertTrue(isEqual(result, sortedList), "SelectionSort no ordenó la lista correctamente");
    }

    private boolean isEqual(Node<Integer> list1, Node<Integer> list2) {
        while (list1 != null && list2 != null) {
            if (!list1.getValue().equals(list2.getValue())) {
                return false;
            }
            list1 = list1.getNext();
            list2 = list2.getNext();
        }
        return list1 == null && list2 == null;
    }
}