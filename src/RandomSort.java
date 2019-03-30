import org.junit.jupiter.api.MethodOrderer;

import java.util.*;

public class RandomSort {
    public static void randomSort(List<Integer> integerList){
        while(!(Helper.isListSorted(integerList))){
            shuffleList(integerList);
        }
    }

    public static void shuffleList(List<Integer> intList)
    {
        Random r = new Random();
        for (int i = intList.size() - 1; i > 0; i--)
        {
            int index = r.nextInt(i + 1);
            int a = intList.get(index);
            intList.set(index,intList.get(i));
            intList.set(i,a);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,12,7,3,12,-1,2);
        randomSort(intList);
        intList.forEach(System.out::println);

    }
}
