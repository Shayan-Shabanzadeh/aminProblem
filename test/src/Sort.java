import java.util.Arrays;

public class Sort {
    public static int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public static void showArray(int[] array) {

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    public static int[] reverseArray(int[] array) {
        int[] reverseArray = new int[array.length];
        int n = array.length;
        for (int i = 0; i < array.length; i++) {
            reverseArray[n - 1] = array[i];
            n -= 1;
        }
        return reverseArray;
    }
}
