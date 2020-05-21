import com.sun.scenario.effect.Merge;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
      int[] array={1,5,4,2,8};
      Sort.showArray(MergeSort.mergeSort(array));
      int[] hello={34,745,234,56,434};
      Sort.showArray(Sort.sort(hello));

    }
}
