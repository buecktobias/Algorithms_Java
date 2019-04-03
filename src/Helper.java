import java.util.Collections;
import java.util.List;

public class Helper {
    public static boolean isListSorted(List<Integer> integerList){
        Integer numberBefore = Integer.MIN_VALUE;  // braucht man eigentlich nicht
        for (Integer integer : integerList) {
            if(integer < numberBefore){
                return false;
            }
            numberBefore = integer;
        }
        return true;
    }
    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
    private static <T>void printArray(T[] arr){
        for (T t : arr) {
            System.out.print(t + ", ");
        }
        System.out.println();
    }
    public static <T> void printList(List<T> list){
        for (T t : list) {
            System.out.print(t +", ");
        }
        System.out.println();
    }
    public static <T> void swap(T[] array,int index1,int index2 ){
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static <T> void swap(List<T> list,int index1,int index2 ){
        Collections.swap(list,index1,index2);
    }
    public static void swap(int[] intArray, int index1, int index2){
        int temp = intArray[index1];
        intArray[index1] = intArray[index2];
        intArray[index2] = temp;
    }
}
