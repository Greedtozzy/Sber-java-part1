import model.City;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final String PATH = "resources/Задача ВС Java Сбер.csv";
    public static void main(String[] args) throws IOException {
        File file = new File(PATH);
        printCity(file);
    }

    private static void printCity(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(System.lineSeparator());
        while (scanner.hasNext()) {
            System.out.println(readLineFromFile(scanner.next()).toString());
        }
        scanner.close();
    }

    private static City readLineFromFile(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.next();
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        long population = scanner.nextLong();
        String foundation;
        try {
            foundation = scanner.next();
        } catch (NoSuchElementException e) {
            foundation = "Не известно";
        }
        return new City(name, region, district, population, foundation);
    }
}
