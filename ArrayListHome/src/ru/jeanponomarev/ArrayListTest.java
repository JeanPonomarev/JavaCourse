package ru.jeanponomarev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();

        ArrayList<String> fileStrings = getAllFileStrings(fileName);

        System.out.println(fileStrings);

        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        for (int i = 0; i < numbers1.size(); ) {
            if (numbers1.get(i) % 2 == 0) {
                numbers1.remove(i);
            } else {
                ++i;
            }
        }

        System.out.println(numbers1);

        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));

        ArrayList<Integer> uniqueNumbers = getUniqueElements(numbers2);

        System.out.println(uniqueNumbers);
    }

    private static ArrayList<String> getAllFileStrings(String fileName) {
        ArrayList<String> fileStrings = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                fileStrings.add(fileReader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Указанный файл не существует, был создан пустой список");
        }

        return fileStrings;
    }

    private static ArrayList<Integer> getUniqueElements(List<Integer> numbers) {
        ArrayList<Integer> resultList = new ArrayList<>();

        for (Integer number : numbers) {
            if (!resultList.contains(number)) {
                resultList.add(number);
            }
        }

        return resultList;
    }
}
