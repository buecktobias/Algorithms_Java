public class InsertionSort {
    public static void insertionSort(int[] intArray){
        insertionSort(intArray,0,intArray.length);
    }
    public static void insertionSort(int[] intArray,int left,int right){
        int i = left + 1;
        while(i < right) {
            int j = i;
            while (j > 0 && intArray[ j - 1] > intArray[j]) {
                Helper.swap(intArray, j, j - 1);
                j--;
            }
            i++;
        }
    }

}
