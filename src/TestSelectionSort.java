import org.junit.jupiter.api.MethodOrderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestSelectionSort {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = randomArrayList(10_000,0,100);
        LinkedList<Integer> integerLinkedList = randomLinkedList(10_000,0,100);
        System.out.println(measureSelectionSort(integerArrayList));
        System.out.println(measureSelectionSort(integerLinkedList));
    }
    public static <T extends Comparable<T>>long measureSelectionSort(List<T> listUnsorted){
        long startTime = System.currentTimeMillis();
        SelectionSort.sort(listUnsorted);
        return System.currentTimeMillis() - startTime;
    }
    public static ArrayList<Integer> randomArrayList(int length,int lowerBound,int upperBound){
        ArrayList<Integer> randomList = new ArrayList<>(length);
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            randomList.add(random.nextInt(upperBound + lowerBound) - lowerBound);
        }
        return randomList;
    }
    public static LinkedList<Integer> randomLinkedList(int length,int lowerBound,int upperBound){
        LinkedList<Integer> randomList = new LinkedList<>();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            randomList.add(random.nextInt(upperBound + lowerBound) - lowerBound);
        }
        return randomList;
    }
 }
