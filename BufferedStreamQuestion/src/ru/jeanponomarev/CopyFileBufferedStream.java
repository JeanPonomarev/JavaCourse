package ru.jeanponomarev;

import java.io.*;

public class CopyFileBufferedStream {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("c:/JavaTest/8_mile.mkv"));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("c:/JavaTest/8_mile_copy.mkv"))) {

            byte[] inputData = new byte[inputStream.available()];

            inputStream.read(inputData);
            outputStream.write(inputData);

            System.out.println("Размер файла: " + (double) inputData.length / 1000000 + " мегабайт");
            System.out.println("Время копирования файла: " + getTimeInSeconds(time) + " секунд");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double getTimeInSeconds(long time) {
        return (double) (System.currentTimeMillis() - time) / 1000;
    }
}
