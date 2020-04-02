package a33_inputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputOutput {

    public static void main(String[] args) {
//        readValuesFromTerminalScanner();
//        readValuesFromTerminalBufferReader();
        writeToFile();
//        readFromFile();
//        stringFormatExample();
    }

    static void readValuesFromTerminalScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите пару слов:");
        String inputText = scanner.nextLine();
        System.out.println("Мы прочитали всю строчку сразу и получили ->" + inputText);
        System.out.println("Напишите еще пару слов:");
        String inputWord = scanner.next();
        System.out.println("Как видно .next() прочитал только первое слово(до пробела) и получили ->" + inputWord);
    }

    static void readValuesFromTerminalBufferReader() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Напишите пару слов:");
        try {
            System.out.println("Buffered reader может прочитать только строчку целиком, чтобы разделить её на слова придется использовать array и separator" + bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println("что то пошло нет так " + e);
        }
    }

    static void writeToFile() {
        File file = new File("textFiles/mytext.txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("some row");
            writer.println("some another row");
            writer.println("row another some");
        } catch (IOException e) {
            System.out.println("Cannot save to file " + e);
        }
        System.out.println("Сделанно. Проверь в директории проекта файл: " + file.getAbsolutePath());
    }

    static void readFromFile() {
        File file = new File("textFiles/mytext.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println("читаем по словам - " + scanner.next());
//                System.out.println("читаем строчку - " + scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Cannot load from a file " + e);
        }
    }

    static void stringFormatExample() {
        int i = 3;
        double r = Math.sqrt(i);
        System.out.println("Корень из числа " + i + " равен " + r );
        System.out.println("Переписав тоже самое с форматом получаем:");
        System.out.format("Корень из числа %d равен %25.2f%n", i, r);
        System.out.println("Где 25 после % означает сколько сделать пробелов, " +
                "а .2 сколько чисел оставлять у дроби после запятой, %n позволяет каретке перейти на следующую строку\n" +
                "можно так же использовать \\n, это работает и в обычном тексте (не printf)");

    }


    //TODO seriazable & Path path example
}
