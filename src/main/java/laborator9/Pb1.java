package laborator9;
import java.util.*;
import java.util.stream.*;

public class Pb1 {
    public static void main(String[] args) {
        // Generăm o listă de 10 numere aleatoare între 5 și 25
        Random rand = new Random();
        List<Integer> numbers = IntStream.range(0, 10)
                .map(i -> rand.nextInt(21) + 5) // [5, 25]
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista generată: " + numbers);

        // a) Suma elementelor
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma elementelor: " + sum);

        // b) Valoarea maximă și minimă
        int max = numbers.stream().mapToInt(Integer::intValue).max().orElseThrow();
        int min = numbers.stream().mapToInt(Integer::intValue).min().orElseThrow();
        System.out.println("Valoarea maximă: " + max);
        System.out.println("Valoarea minimă: " + min);

        // c) Elementele în intervalul [10..20]
        List<Integer> filtered = numbers.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("Elemente în intervalul [10..20]: " + filtered);

        // d) Conversie în Double
        List<Double> doubleList = numbers.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());
        System.out.println("Lista convertită în Double: " + doubleList);

        // e) Verificare dacă lista conține valoarea 12
        boolean contains12 = numbers.contains(12);
        System.out.println("Conține valoarea 12? " + contains12);
    }
}

