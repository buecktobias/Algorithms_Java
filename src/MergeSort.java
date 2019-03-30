import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {

    public static int[] append(int[] array,int[] array2){
        return new int[0];
    }
    public static void mergeSort(int[] array){
        mergeSort(array,0, array.length-1);
    }
    private static void mergeSort(int[] array,int left,int right) {
        if (left < right) {
            int m = left + (right - left) / 2;
            mergeSort(array, left, m);
            mergeSort(array, m, right);
            mergeTwoSortedLists(array,left,m,right);
        }
    }
    private static void mergeTwoSortedLists(int[] list,int left,int middle,int right){
        int[] result = new int[Math.abs(right-left)];
        int indexleft = left;
        int indexright = middle;
        for(int i=0;i < result.length ; i++){
            int valueInFirstList;
            int valueInSecondList;
            if(indexleft >= middle){
                valueInFirstList = 99999999;
            }else{
                valueInFirstList = list[indexleft];
            }

            if(indexright >= right){
                valueInSecondList = 99999999;
            }else{
                valueInSecondList = list[indexright];
            }
            if(valueInFirstList < valueInSecondList){
                result[i] = valueInFirstList;
                indexleft++;
            }else{
                result[i] = valueInSecondList;
                indexright++;
            }
        }
        for (int i = left; i < right-1; i++) {
            list[i] = result[i];
        }
    }
    public static void main(String[] args) {
        int[] array1 = new int[]{99999999,-50000000,1,11,2,4};
        mergeTwoSortedLists(array1,2,3,6);
        printArray(array1);
    }
    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
