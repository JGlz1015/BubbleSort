
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void bubbleSort(int[] array) {
        bubbleSort(array, 0, array.length);
    }

    public static void bubbleSort(int[] array, int start, int end) {
        if (end - start <= 1)
            return;

        for (int i = start; i < end - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
            }
        }

        bubbleSort(array, start, end - 1);
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    public static int[] createRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        for (int i = 0; i < array.length; i++) {
            fileWriter.write(array[i] + "\n");
        }
        fileWriter.close();
    }

    public static int[] readArrayFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            arrayList.add(Integer.parseInt(scanner.nextLine()));
        }
        scanner.close();
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        int[] array = createRandomArray(10);  // Adjust the length as needed
        System.out.println("Generated Array: " + Arrays.toString(array));

        writeArrayToFile(array, "array.txt");

        array = readArrayFromFile("array.txt");
        System.out.println("Read Array: " + Arrays.toString(array));

        bubbleSort(array);
        writeArrayToFile(array, "sorted_array.txt");

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}


