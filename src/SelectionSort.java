import de.gmo.sae.sorting.visualization.ArrayVisualizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    public static int[] sort(int[] intArray){
        Integer[] arr = IntStream.of(intArray).boxed().toArray(Integer[]::new);
        sort(arr);
        return integerArrayToIntArray(arr);
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
        int[] intArray = new int[]{3,8,2,9,3};

        List<Integer> ints = Arrays.asList(4,9,2,1,23,45,12,34,12,34,54,62,13,15,1);
        Character[] chars = new Character[]{'a','z','b','c','x','y','e'};
        String[] strings = new String[]{"Hallo","Baum","Haus","Auto","Tisch","AAAAA"};

        sort(ints);
        Helper.printList(ints);
    }

}
