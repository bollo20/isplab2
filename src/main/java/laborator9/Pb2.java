package laborator9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Pb2 {
    public static void main(String[] args) {
        List<Integer> initialList = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        System.out.println("Lista inițială: " + initialList);

        List<Integer> squaredDistinct = initialList.stream()
                .map(n -> n * n)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Lista pătratelor distincte: " + squaredDistinct);
    }
}
