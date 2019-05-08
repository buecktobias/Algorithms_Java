import de.gmo.sae.sorting.visualization.ArrayVisualizer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class SelectionSort {
    public static int[] integerArrayToIntArray(Integer[] arr){
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = (int)arr[i];
        }
        return intArr;
    }
    public static void sort(int[] intArray,boolean visualize){
        if(visualize){
            sort(intArray);
        }else{
            sortNoVisualization(intArray);
        }
    }
    public static void sortNoVisualization(int[] intArray){
        int minIndex;
        for(int i = 0; i < intArray.length;i++){
            minIndex = min(intArray,i,intArray.length);
            Helper.swap(intArray,i,minIndex);
        }
    }
    public static void sort(int[] intArray){
        ArrayVisualizer arrayVisualizer = new ArrayVisualizer(intArray);
        int minIndex;
        for(int i = 0; i < intArray.length;i++){
            minIndex = min(intArray,i,intArray.length);
            Helper.swap(intArray,i,minIndex);
            arrayVisualizer.visualize();
        }
    }
    public static <T extends Comparable<T>>void sort(List<T> list){
        int minIndex;
        for(int i = 0; i < list.size();i++){
            minIndex = min(list,i,list.size());
            Helper.swap(list,i,minIndex);
        }
    }


    public static <T extends Comparable<T>>void sort(T[] array){
        int minIndex;
        for(int i = 0; i < array.length;i++){
            minIndex = min(array,i,array.length);
            Helper.swap(array,i,minIndex);
        }
    }

    public static int min(int[] intArray,int from,int to){
        if (intArray.length > 0) {
            int min = intArray[from];
            int minIndex = from;
            for (int i = from + 1; i < to; i++) {
                if (intArray[i] < min) {
                    min = intArray[i];
                    minIndex = i;
                }
            }
            return minIndex;
        }
        return -1;
    }

    public static <T extends Comparable<T>>int min(T[] arr,int from,int to) {
        if (arr.length > 0) {
            T min = arr[from];
            int minIndex = from;
            for (int i = from + 1; i < to; i++) {
                if (arr[i].compareTo(min) < 0) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            return minIndex;
        }
        return -1;
    }
    public static <T extends Comparable<T>>int min(List<T> list,int from,int to) {
        if (list.size() > 0) {
            T min = list.get(from);
            int minIndex = from;
            for (int i = from + 1; i < to; i++) {
                if (list.get(i).compareTo(min) < 0) {
                    min = list.get(i);
                    minIndex = i;
                }
            }
            return minIndex;
        }
        return -1;
    }



    public static void main(String[] args) {
        Integer[] intArray = TestingPerformanceAlgorithms.randomIntArray(350,0,100_000_000);
        List<Integer> integerList = (ArrayList<Integer>)Arrays.asList(1,4,23,43,54,12,32,43);
        List<Integer> integerLinkedList = (LinkedList<Integer>)Arrays.asList(1,4,23,43,54,12,32,43);

        sort(integerList);
        Helper.printList(integerList);
    }

}
