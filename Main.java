import java.util.*;
import java.io.*;

public class Main {
    private static final String FILE_NAME = "Numbers.txt";
    private static Node<Integer> head;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("************* ¡BIENVENIDO! *************");
            System.out.println("1. Generar números aleatorios");
            System.out.println("2. Cargar archivo de números aleatorios");
            System.out.println("3. Ordenar números con Gnome Sort");
            System.out.println("4. Ordenar números con Merge Sort");
            System.out.println("5. Ordenar números con Quick Sort");
            System.out.println("6. Ordenar números con Radix Sort");
            System.out.println("7. Ordenar números con Selection Sort");
            System.out.println("8. Salir");
            System.out.println("****************************************");
            System.out.print("Por favor, selecciona una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    generateRandomNumbers();
                    System.out.println("¡Números aleatorios generados y guardados en '" + FILE_NAME + "'!");
                    break;
                case 2:
                    loadNumbersFromFile();
                    System.out.println("¡Números aleatorios cargados del archivo '" + FILE_NAME + "'!");
                    break;
                case 3:
                    head = sortNumbers(new GnomeSort<>());
                    if (head != null) {
                        System.out.println("¡Números ordenados con Gnome Sort exitosamente!");
                    }
                    break;
                case 4:
                    head = sortNumbers(new MergeSort<>());
                    if (head != null) {
                        System.out.println("¡Números ordenados con Merge Sort exitosamente!");
                    }
                    break;
                case 5:
                    head = sortNumbers(new QuickSort<>());
                    if (head != null) {
                        System.out.println("¡Números ordenados con Quick Sort exitosamente!");
                    }
                    break;
                case 6:
                    head = sortNumbers(new RadixSort<>());
                    if (head != null) {
                        System.out.println("¡Números ordenados con Radix Sort exitosamente!");
                    }
                    break;
                case 7:
                    head = sortNumbers(new SelectionSort<>());
                    if (head != null) {
                        System.out.println("¡Números ordenados con Selection Sort exitosamente!");
                    }
                    break;
                case 8:
                    System.out.println("¡Adiós!");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
            }
        }
    }

    private static void generateRandomNumbers() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingresa la cantidad de números a generar (entre 10 y 3000): ");
        int n = scanner.nextInt();
    
        if (n < 10 || n > 3000) {
            System.out.println("Número inválido. Por favor, intenta de nuevo.");
            return;
        }
    
        Random random = new Random();
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < n; i++) {
                writer.println(random.nextInt());
            }
        }
    }

    private static void loadNumbersFromFile() throws IOException {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            Node<Integer> current = null;
            while (scanner.hasNextInt()) {
                Node<Integer> node = new Node<>(scanner.nextInt());
                if (current == null) {
                    head = node;
                } else {
                    current.setNext(node);
                    node.setPrevious(current);
                }
                current = node;
            }
        }
    }

    private static Node<Integer> sortNumbers(ISort<Integer> sortAlgorithm) {
        if (head == null) {
            System.out.println("Por favor, carga los números del archivo primero.");
            return null;
        } else {
            return sortAlgorithm.sort(head);
        }
    }
}