public class BubbleSort {
    public static void bubbleSortOptimized(int[] intArray,boolean reversed){
        boolean elementsSwapped = true;
        int lastIndexHastToBeCompared = intArray.length;
        while(elementsSwapped){
            elementsSwapped = false;
            for (int i = 1; i < lastIndexHastToBeCompared; i++) {
                if(!reversed) {
                    if (intArray[i] < intArray[i - 1]) {
                        elementsSwapped = true;
                        Helper.swap(intArray, i - 1, i);
                    }
                }else{
                    if(intArray[i] > intArray[i-1]){
                        elementsSwapped = true;
                        Helper.swap(intArray, i - 1, i);
                    }
                }
            }
            lastIndexHastToBeCompared--;
        }
    }

    public static void bubbleSort(int[] intArray) {
        bubbleSort(intArray,false);
    }
    public static void bubbleSortOptimized(int[] intArray){ bubbleSortOptimized(intArray,false);}

    public static void bubbleSort(int[] intArray, boolean reversed){
        boolean elementsSwapped = true;
        while(elementsSwapped){
            elementsSwapped = false;
            for (int i = 1; i < intArray.length; i++) {
                if(!reversed) {
                    if (intArray[i] < intArray[i - 1]) {
                        elementsSwapped = true;
                        Helper.swap(intArray, i - 1, i);
                    }
                }else{
                    if(intArray[i] > intArray[i-1]){
                        elementsSwapped = true;
                        Helper.swap(intArray, i - 1, i);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] intArray = new int[]{-10,7,2,56,21,34,1,90};
        bubbleSortOptimized(intArray,true);
        Helper.printArray(intArray);
    }
}
