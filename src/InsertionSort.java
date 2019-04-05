import de.gmo.sae.sorting.visualization.ArrayVisualizer;

public class InsertionSort {
    public static void insertionSort(int[] intArray){
        insertionSort(intArray,0,intArray.length);
    }
    public static void insertionSort(int[] intArray,int left,int right){
        ArrayVisualizer arrayVisualizer = new ArrayVisualizer(intArray);
        int i = left + 1;
        while(i < right) {
            int j = i;
            while (j > 0 && intArray[ j - 1] > intArray[j]) {
                Helper.swap(intArray, j, j - 1);
                arrayVisualizer.visualize();
                j--;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] intArray = TestingPerformanceAlgorithms.randomIntArray(100,0,100);
        insertionSort(intArray);
    }

}
