public class QuickSort {

    public static void swapTwoElements(int[] intArray,int index1,int index2){
        int temp = intArray[index1];
        intArray[index1] = intArray[index2];
        intArray[index2] = temp;
    }
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
                swapTwoElements(intArray,leftIndex,rightIndex);
            }

        }while(leftIndex < rightIndex);
        if(intArray[leftIndex] > pivotValue){
            swapTwoElements(intArray,leftIndex,startedRightIndex);
        }
        quickSort(intArray,startedLeftIndex,leftIndex-1);
        quickSort(intArray,leftIndex + 1,startedRightIndex);
    }

    public static void main(String[] args) {

    }
    public void makeThreads(){
        for(int i = 0; i < 4; i++){
            QuickSortThread t1 = new QuickSortThread();
            t1.start();
        }
    }

    private class QuickSortThread extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 100;i++) {
                System.out.println(Thread.currentThread().getId() + " Hallo "+ i);
            }
        }
    }
}

