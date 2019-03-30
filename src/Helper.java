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
    }
    public static void swapTwoElements(int[] intArray,int index1,int index2){
        int temp = intArray[index1];
        intArray[index1] = intArray[index2];
        intArray[index2] = temp;
    }
}
