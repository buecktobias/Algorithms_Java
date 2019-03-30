public class QuickSort {
    public static void quickSort(int[] intArray){
        quickSort(intArray,0,intArray.length - 1);
    }

    private static void quickSort(int[] intArray, final int startedLeftIndex, final int startedRightIndex){
        if(startedLeftIndex >= startedRightIndex){
            return;
        }
        int rightIndex = startedRightIndex - 1;
        int leftIndex = startedLeftIndex;
        int pivotValue = intArray[startedRightIndex];
        do{
            while(intArray[leftIndex] <= pivotValue && leftIndex < startedRightIndex){
                leftIndex++;
            }
            while(intArray[rightIndex] >= pivotValue && rightIndex > startedLeftIndex){
                rightIndex--;
            }
            if(leftIndex < rightIndex){
                Helper.swapTwoElements(intArray,leftIndex,rightIndex);
            }

        }while(leftIndex < rightIndex);
        if(intArray[leftIndex] > pivotValue){
            Helper.swapTwoElements(intArray,leftIndex,startedRightIndex);
        }
        quickSort(intArray,startedLeftIndex,leftIndex-1);
        quickSort(intArray,leftIndex + 1,startedRightIndex);
    }
}

