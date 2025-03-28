package laborator5;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        List<String> lines = Arrays.asList(
                "Lorem ipsum dolor sit amet, vim ne eripuit vulputate.",
                "Vide tantas dicunt ne ius, mel pertinacia intellegebat ei.",
                "Sea vidisse aperiam et, eu altera audiam percipitur vis, decore verterem ea nec.",
                "Veri quando ad est. Ex quidam blandit nec, eos et percipit indoctum.",
                "\n",
                "Summo putant consetetur cu vel. Id eum adipisci philosophia, eos principes an.",
                "Duis eripuit laoreet qui ne, pri maiorum detracto definitiones et.",
                "Sea quis laudem dolorem eu."
        );
        try {
            System.out.print("Writing outfile1.txt ... ");
            writeSmallTextFile(lines, "outfile1.txt");
            System.out.println("done");
            System.out.print("\n Writing outfile2.txt ... ");
            writeLargerTextFile(lines, "outfile2.txt");
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void writeSmallTextFile(List<String> lines, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, lines);
    }
    static void writeLargerTextFile(List<String> lines, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            for(String line : lines){
                writer.write(line);
                writer.newLine();
            }
        }
    }
}