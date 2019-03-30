import org.junit.jupiter.api.MethodOrderer;

import java.util.Arrays;

public class TestingPerformanceAlgorithms {
    public static void main(String[] args) {

        //for(int i = 10; i < 100_000;i += 1_000){
//            int[] test = randomIntArray(i);
//            int[] testCopy= Arrays.copyOf(test,test.length);
//            int[] testCopy2 = Arrays.copyOf(test,test.length);
//            System.out.println(bubbleSortOptimizedMeasured(test) + "\t" + bubbleSortTimeMeasured(testCopy) + "\t" + quickSortTimeMeasured(testCopy2));
//        }
        int[] test = randomIntArray(1_000_000);
        System.out.println(quickSortTimeMeasured(test));
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static long quickSortTimeMeasured(int[] intArray){
        long startQuickSort = System.currentTimeMillis();
        QuickSort.quickSort(intArray);
        return System.currentTimeMillis() - startQuickSort;
    }
    public static long bubbleSortTimeMeasured(int[] intArray){
        long startBubbleSort = System.currentTimeMillis();
        BubbleSort.bubbleSort(intArray);
        long bubbleSort = System.currentTimeMillis() - startBubbleSort;
        return bubbleSort;
    }
    public static long bubbleSortOptimizedMeasured(int[] intArray){
        long startBubbleSort = System.currentTimeMillis();
        BubbleSort.bubbleSortOptimized(intArray);
        long bubbleSort = System.currentTimeMillis() - startBubbleSort;
        return bubbleSort;

    }


    public static int[] randomIntArray(int length){
        java.util.Random random = new java.util.Random();
        int[] randomArray = new int[length];
        for (int i=0;i < randomArray.length;i++) {
            randomArray[i] = (random.nextInt(Integer.MAX_VALUE)) - Integer.MAX_VALUE;
        }
        return randomArray;
    }
    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
