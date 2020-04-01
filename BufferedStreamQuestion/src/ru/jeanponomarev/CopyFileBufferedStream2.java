package ru.jeanponomarev;

import java.io.*;

public class CopyFileBufferedStream2 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("c:/JavaTest/8_mile.mkv"));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("c:/JavaTest/8_mile_copy.mkv"))) {

            byte[] inputData = new byte[inputStream.available() + 1];

            int off = 0;
            int read;
            int iterationsCount = 0;

            while ((read = inputStream.read(inputData, off, inputData.length - off)) != -1) {
                ++iterationsCount;
                off += read;
            }
            outputStream.write(inputData);

            System.out.println("Размер файла: " + (double) inputData.length / 1000000 + " мегабайт");
            System.out.println("Время копирования файла: " + getTimeInSeconds(time) + " секунд");
            System.out.println("Количество итераций при чтении: " + iterationsCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double getTimeInSeconds(long time) {
        return (double) (System.currentTimeMillis() - time) / 1000;
    }
}
