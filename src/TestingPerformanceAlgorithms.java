import java.util.Arrays;

public class TestingPerformanceAlgorithms {
    public static void main(String[] args) {

        //for(int i = 10; i < 100_000;i += 1_000){
//            int[] test = randomIntArray(i);
//            int[] testCopy= Arrays.copyOf(test,test.length);
//            int[] testCopy2 = Arrays.copyOf(test,test.length);
//            System.out.println(bubbleSortOptimizedMeasured(test) + "\t" + bubbleSortTimeMeasured(testCopy) + "\t" + quickSortTimeMeasured(testCopy2));
//        }



        int[] test1 = randomIntArray(1_000_000);
        int[] test2 = Arrays.copyOf(test1,test1.length);
        int[] test3 = Arrays.copyOf(test1,test1.length);
        System.out.println("QuickSort optimized with insertionSort " + measureQuickSortInsertionSortOptimized(test1)/10_000);
        System.out.println("QuickSort " + quickSortTimeMeasured(test2)/10_000);
        System.out.println("Builtin " + measureBuiltinSortingAlgorithm(test3)/ 10_000);
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


    public static int[] randomIntArray(int length){
        java.util.Random random = new java.util.Random();
        int[] randomArray = new int[length];
        for (int i=0;i < randomArray.length;i++) {
            randomArray[i] = (random.nextInt(Integer.MAX_VALUE)) - Integer.MAX_VALUE;
        }
        return randomArray;
    }

    public static int[] randomIntArray(int length, int lowerBound,int upperBound){
        java.util.Random random = new java.util.Random();
        int[] randomArray = new int[length];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(upperBound + lowerBound) - lowerBound;
        }
        return randomArray;
    }

    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
