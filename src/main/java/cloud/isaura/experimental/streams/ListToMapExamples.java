package cloud.isaura.experimental.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListToMapExamples
{

    public static void main(String[] args)
    {
        //
        List<Integer> integerList = Arrays.asList(1,2,1,2,1,3,2);
        Map<Integer, Long> elementsByKey = integerList
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
         elementsByKey
                .entrySet()
                .stream()
                .forEach(entry -> entry.setValue(entry.getValue() / 2) );
         long sum = elementsByKey.values().stream().mapToLong(Long::longValue).sum();

        System.out.println("sum "+sum);
    }
}
