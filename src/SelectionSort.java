public class SelectionSort {
    public static <T extends Comparable<T>>int min(T[] comparables,int from,int to){
        T min = comparables[from];
        int minIndex = from;
        for(int i = from+1;i < to;i++){
            if(comparables[i].compareTo(min) < 0){
                min = comparables[i];
                minIndex = i;
            }
        }
        return minIndex;

    }
    public static <T extends Comparable<T>>void sort(T[] array){
        int minIndex;
        for(int i = 0; i < array.length;i++){
            minIndex= min(array,i,array.length);
            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{4,9,2,1,23,45,12,34,12,34,54,62,13,15,1};
        Character[] chars = new Character[]{'a','z','b','c','x','y','e'};

        sort(ints);
        sort(chars);
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }
        for (Character aChar : chars) {
            System.out.println(aChar);
        }
    }
}
