import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestingPerformanceAlgorithms {
    public static void main(String[] args) {
//      for(int i = 10; i < 100_000;i += 1_000){
//            int[] test = randomIntArray(i);
//            int[] testCopy= Arrays.copyOf(test,test.length);
//            int[] testCopy2 = Arrays.copyOf(test,test.length);
//            System.out.println(bubbleSortOptimizedMeasured(test) + "\t" + bubbleSortTimeMeasured(testCopy) + "\t" + quickSortTimeMeasured(testCopy2));
//        }
          testBubbleSortTimeComplexity();
//        int[] test1 = randomIntArray(1_000_000);
//        int[] test2 = Arrays.copyOf(test1,test1.length);
//        int[] test3 = Arrays.copyOf(test1,test1.length);
//        System.out.println("QuickSort optimized with insertionSort " + measureQuickSortInsertionSortOptimized(test1)/10_000);
//        System.out.println("QuickSort " + quickSortTimeMeasured(test2)/10_000);
//        System.out.println("Builtin " + measureBuiltinSortingAlgorithm(test3)/ 10_000);
    }

    private static void testBubbleSortTimeComplexity(){
        System.out.println("array length\tbubbleSort\tbubbleSortTimeOptimized\tselectionSort\tquickSort\trandomSort\tinsertionSort" );
        final int ITERATIONS = 10;
        final int MAX_LENGTH = 5_000;
        final int STEPS = 10;
        for(int n = STEPS; n <  MAX_LENGTH;n+=STEPS) {
            long sumBubbleSort = 0;
            long sumBubbleSortTimeOptimized = 0;
            long sumSelectionSort = 0;
            long sumQuickSort = 0;
            long sumRandomSort = 0;
            long sumInsertionSort = 0;

            for (int i = 0; i < ITERATIONS; i++) {
                int[] ints = randomIntArray(n);
                int[] ints2 = ints.clone();
                int[] ints3 = ints.clone();
                int[] ints4 = ints.clone();
                int[] ints5 = ints.clone();
                int[] ints6 = ints.clone();
                List<Integer> listInts4 = arrayToList(ints4);
                sumBubbleSort += bubbleSortTimeMeasured(ints);
                sumSelectionSort += measureSelectionSort(ints2);
                sumQuickSort += quickSortTimeMeasured(ints3);
                sumBubbleSortTimeOptimized += bubbleSortOptimizedMeasured(ints6);
                if (n < 10) {
                    sumRandomSort += measureRandomSort(listInts4);
                }
                sumInsertionSort += measureInsertionSort(ints5);
            }
            double bubbleSortAverage = sumBubbleSort / ITERATIONS;
            double selectionSortAverage = sumSelectionSort / ITERATIONS;
            double quickSortAverage = sumQuickSort / ITERATIONS;
            double randomSortAverage = sumRandomSort / ITERATIONS;
            double insertionSortAverage = sumInsertionSort / ITERATIONS;
            double bubbleSortTimeOptimized = sumBubbleSortTimeOptimized / ITERATIONS;
            System.out.println(n + "\t" + (int)bubbleSortAverage + "\t" + (int)bubbleSortTimeOptimized + "\t" + (int)selectionSortAverage + "\t" + (int)quickSortAverage + "\t" + (int)randomSortAverage + "\t" + (int)insertionSortAverage);
        }
    }



    public static long measureQuickSortInsertionSortOptimized(int[] intArray){
        long startQuickSortOptimized = System.nanoTime();
        QuickSort.quickSortPivotLastInsertionSort(intArray);
        return System.nanoTime() - startQuickSortOptimized;


    }

    public static long measureInsertionSort(int[] intArray){
        long startInsertionSort = System.nanoTime();
        InsertionSort.insertionSort(intArray);
        return System.nanoTime() - startInsertionSort;
    }
    public static long measureBuiltinSortingAlgorithm(int[] intArray){
        long startBuiltInSort = System.nanoTime();
        Arrays.sort(intArray);
        return System.nanoTime() - startBuiltInSort;

    }
    public static long quickSortTimeMeasured(int[] intArray){
        long startQuickSort = System.nanoTime();
        QuickSort.quickSortPivotLast(intArray);
        return System.nanoTime() - startQuickSort;
    }
    public static long bubbleSortTimeMeasured(int[] intArray){
        long startBubbleSort = System.nanoTime();
        BubbleSort.bubbleSort(intArray);
        long bubbleSort = System.nanoTime() - startBubbleSort;
        return bubbleSort;
    }
    public static long bubbleSortOptimizedMeasured(int[] intArray){
        long startBubbleSort = System.nanoTime();
        BubbleSort.bubbleSortOptimized(intArray);
        long bubbleSort = System.nanoTime() - startBubbleSort;
        return bubbleSort;

    }
    public static List<Integer> arrayToList(int[] intArray){
        List<Integer> result = new ArrayList<>(intArray.length);
        for (int i : intArray) {
            result.add(i);
        }
        return result;
    }
    public static long measureRandomSort(List<Integer> intList){
        long startTime = System.nanoTime();
        RandomSort.randomSort(intList);
        return System.nanoTime() - startTime;
    }


    public static int[] randomIntArray(int length){
        java.util.Random random = new java.util.Random();
        int[] randomArray = new int[length];
        for (int i=0;i < randomArray.length;i++) {
            randomArray[i] = (random.nextInt(Integer.MAX_VALUE)) - Integer.MAX_VALUE;
        }
        return randomArray;
    }

    public static Integer[] randomIntArray(int length, int lowerBound,int upperBound){
        java.util.Random random = new java.util.Random();
        Integer[] randomArray = new Integer[length];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(upperBound + lowerBound) - lowerBound;
        }
        return randomArray;
    }
    public static <T extends Comparable<T>>long measureSelectionSort(List<T> listUnsorted){
        long startTime = System.currentTimeMillis();
        SelectionSort.sort(listUnsorted);
        return System.currentTimeMillis() - startTime;
    }
    public static long measureSelectionSort(int[] intArray){
        long startTime = System.nanoTime();
        SelectionSort.sortNoVisualization(intArray);
        return System.nanoTime() - startTime;
    }

    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
