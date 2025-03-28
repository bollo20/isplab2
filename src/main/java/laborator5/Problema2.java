package laborator5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Problema2 {
    public static void main(String[] args) {
        try {
            // Clear the file at the beginning
            clearFile("outrand.txt");

            // Generate and write the words
            generateAndWriteWords("outrand.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void clearFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
    }

    static void generateAndWriteWords(String fileName) throws IOException {
        List<String> words = new ArrayList<>();
        Random random = new Random();
        // Generate 50 words (5 lines * 10 words per line)
        for (int i = 0; i < 50; i++) {
            words.add(generateRandomWord(random));
        }

        // Sort the words in lexicographical order
        Collections.sort(words);

        // Prepare words for output, 10 words per line
        List<String> outputLines = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                line.append(words.get(i * 10 + j)).append(" ");
            }
            outputLines.add(line.toString().trim());
        }

        // Write the words to the file
        writeToFile(outputLines, fileName);
    }

    static String generateRandomWord(Random random) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char letter = (char) ('a' + random.nextInt(26)); // Random letter between 'a' and 'z'
            word.append(letter);
        }
        return word.toString();
    }

    static void writeToFile(List<String> lines, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}

