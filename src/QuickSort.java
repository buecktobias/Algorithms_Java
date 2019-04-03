public class QuickSort {
    public static void quickSortPivotLast(int[] intArray){
        quickSortPivotLast(intArray,0,intArray.length - 1,false,0);
    }
    public static void quickSortPivotLastInsertionSort(int[] intArray){
        quickSortPivotLast(intArray,0,intArray.length - 1,true,64);

    }
    private static void quickSortPivotLast(int[] intArray, final int startedLeftIndex, final int startedRightIndex,final boolean insertionSort,int maxInsertionSotLength){
        if(startedLeftIndex >= startedRightIndex){
            return;
        }
        if(insertionSort && startedRightIndex - startedLeftIndex < maxInsertionSotLength) {
                InsertionSort.insertionSort(intArray, startedLeftIndex, startedRightIndex);
        }else {
            int rightIndex = startedRightIndex - 1;
            int leftIndex = startedLeftIndex;
            int pivotValue = intArray[startedRightIndex];
            do {
                while (intArray[leftIndex] <= pivotValue && leftIndex < startedRightIndex) {
                    leftIndex++;
                }
                while (intArray[rightIndex] >= pivotValue && rightIndex > startedLeftIndex) {
                    rightIndex--;
                }
                if (leftIndex < rightIndex) {
                    Helper.swap(intArray, leftIndex, rightIndex);
                }

            } while (leftIndex < rightIndex);
            if (intArray[leftIndex] > pivotValue) {
                Helper.swap(intArray, leftIndex, startedRightIndex);
            }
            quickSortPivotLast(intArray, startedLeftIndex, leftIndex - 1, insertionSort,maxInsertionSotLength);
            quickSortPivotLast(intArray, leftIndex + 1, startedRightIndex, insertionSort,maxInsertionSotLength);
        }
    }
    private static void quickSortPivotRandom(int[] intArray,final int startedLeftIndex,final int startedRightIndex){
        if(startedLeftIndex >= startedRightIndex){
            return;
        }
        int rightIndex = startedRightIndex;
        int leftIndex = startedLeftIndex;
        int pivotIndex = new java.util.Random().nextInt(startedRightIndex-startedLeftIndex) + startedLeftIndex;
        int pivotValue = intArray[pivotIndex];
        do{
            while(intArray[leftIndex] <= pivotValue && leftIndex < startedRightIndex){
                leftIndex++;
            }
            while(intArray[rightIndex] >= pivotValue && rightIndex > startedLeftIndex){
                rightIndex--;
            }
            if(leftIndex < rightIndex){
                Helper.swap(intArray,leftIndex,rightIndex);
            }

        }while(leftIndex < rightIndex);
        if(intArray[leftIndex] > pivotValue){
            Helper.swap(intArray,leftIndex,startedRightIndex);
        }
        quickSortPivotRandom(intArray,startedLeftIndex,leftIndex-1);
        quickSortPivotRandom(intArray,leftIndex + 1,startedRightIndex);
    }

    }

