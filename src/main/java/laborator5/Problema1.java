package laborator5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Problema1{
    public static void main(String[] args) {
        try {
            // Clear the file at the beginning
            clearFile("out.txt");

            System.out.println("EX 1");
            printSmallTextFileWithNewLine("infile.txt");
            System.out.println("EX 2");
            printSmallTextFile2("infile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void clearFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
    }

    static void printSmallTextFileWithNewLine(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> allLinesInMemory = Files.readAllLines(path);
        writeSmallTextFile(allLinesInMemory, "out.txt");
        for (String line : allLinesInMemory) {
            System.out.println(": " + line + "\n");
        }
    }

    static void printSmallTextFile2(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> allLinesInMemory = Files.readAllLines(path);
        List<String> sentencesList = new ArrayList<>();
        for (String line : allLinesInMemory) {
            String[] sentences = line.split("\\.");
            for (String sentence : sentences) {
                sentencesList.add(sentence.trim() + ".");
            }
        }
        writeSmallTextFile(sentencesList, "out.txt");
        for (String sentence : sentencesList) {
            System.out.println(sentence);
        }
    }

    static void writeSmallTextFile(List<String> lines, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, List.of("\n Scriere noua \n"), StandardOpenOption.APPEND);
        Files.write(path, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

    }
}