package laborator9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pb3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Acesta", "este", "un", "program", "scris", "cu", "java", "8", "si", "expresii", "lambda");

        // a) Cuvintele cu lungime >= 5 caractere
        List<String> longWords = words.stream()
                .filter(w -> w.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("Cuvinte cu lungime >= 5: " + longWords);
        System.out.println("Număr: " + longWords.size());

        // b) Ordonarea listei filtrate
        List<String> sorted = longWords.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Lista ordonată: " + sorted);

        // c) Cuvânt care începe cu litera 'p'
        String wordStartingWithP = words.stream()
                .filter(w -> w.startsWith("p"))
                .findFirst()
                .orElse("Nu există un cuvânt care începe cu 'p'");
        System.out.println("Cuvânt care începe cu 'p': " + wordStartingWithP);
    }
}

