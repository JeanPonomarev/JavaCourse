package ru.jeanponomarev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> fileStrings = getAllFileStrings();

        if (!fileStrings.isEmpty()) {
            for (String line : fileStrings) {
                System.out.println(line);
            }
        }

        System.out.println();

        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        numbers1.removeIf(x -> (x % 2 == 0));

        for (Integer number : numbers1) {
            System.out.print(number + " ");
        }

        System.out.println(System.lineSeparator());

        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));

        ArrayList<Integer> uniqueNumbers = removeAllCopies(numbers2);

        for (Integer number : uniqueNumbers) {
            System.out.print(number + " ");
        }
    }

    private static ArrayList<String> getAllFileStrings() {
        ArrayList<String> fileStrings = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название и путь к файлу");
        String fileName = scanner.nextLine();
        scanner.close();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                fileStrings.add(fileReader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Указанный файл не существует, был создан пустой список");
        }

        return fileStrings;
    }

    private static ArrayList<Integer> removeAllCopies(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                resultList.add(number);
                uniqueNumbers.add(number);
            }
        }

        return resultList;
    }
}
