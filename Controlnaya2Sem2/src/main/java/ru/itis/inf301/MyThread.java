package ru.itis.inf301;

import java.io.*;

public class MyThread extends Thread {
    private String filename;
    private byte[] data;
    private int partNum;
    private int evenOrOdd;
    private int even;
    private int size;

    public MyThread(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try (DataInputStream is = new DataInputStream(new FileInputStream(filename))) {
            size = is.readInt();
            data = is.readNBytes(size);
            even = is.readInt();
            partNum = is.readInt();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPartNum() {
        return partNum;
    }

    public byte[] getData() {
        return data;
    }

    public void countEven() {
        evenOrOdd = countEven(data) % 2;
    }

    public static int countEven(byte[] array) {
        int evenData = 0;
        for (int i = 0; i < array.length; ++i) {
            int tmp = array[i] & 0xFF;
            while (tmp != 0) {
                evenData += tmp & 1;
                tmp = tmp >> 1;
            }
        }
        return evenData;
    }

    public int getEvenOrOdd() {
        return evenOrOdd;
    }

    public int getEven() {
        return even;
    }
}
