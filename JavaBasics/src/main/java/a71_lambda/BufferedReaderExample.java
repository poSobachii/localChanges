package a71_lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class BufferedReaderExample {
    public static void main(String[] args) throws IOException {
//            simpleExample();
            readStreamOfLinesUsingFilesWithTryBlock();

    }


    public static void simpleExample() throws IOException {
        String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);

    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("LamdaExpression/inputFiles/text.txt"))) {
            return p.process(br);
        }

    }

    public static void readStreamOfLinesUsingFilesWithTryBlock() throws IOException {
        Path path = Paths.get("LamdaExpression/inputFiles/text.txt");

        try (Stream<String> lines = Files.lines(path)) {
            Optional<String> hasPassword = lines.filter(s -> s.contains("some text")).findFirst();

            if (hasPassword.isPresent()) {
                System.out.println(hasPassword.get());
            }
        }
    }
}


interface BufferedReaderProcessor {
    public String process(BufferedReader b) throws IOException;

}
