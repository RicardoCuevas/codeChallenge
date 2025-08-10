import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        conversionData();
    }

    public static void conversionData() {

        String[] array = {"A","B","C"};
        List<String> list = Arrays.asList(array);
        list.stream().forEach(System.out::print);
        System.out.println();
        int[] intArray = {1,2,3};
        List<Integer> intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        intList.stream().forEach(System.out::print);
        System.out.println();
        List<Integer> numberList = List.of(1,2,3,4,5,6,7);
        Integer[] intArrays = numberList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(intArrays));
    }
}
