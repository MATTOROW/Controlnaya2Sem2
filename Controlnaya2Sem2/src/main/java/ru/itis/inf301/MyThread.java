package ru.itis.inf301;

import java.io.*;

public class MyThread extends Thread {
    private String filename;
    private byte[] data;
    private int partNum;
    private int evenOrOdd;
    private int even;

    public MyThread(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try (DataInputStream is = new DataInputStream(new FileInputStream(filename))) {
            int size = is.readInt();
            data = is.readNBytes(size);
            even = is.readInt();
            partNum = is.readInt();
            int evenData = 0;
            for (int i = 0; i < size; ++i) {
                int tmp = data[i] & 0xFF;
                while (tmp != 0) {
                    evenData += tmp & 1;
                    tmp = tmp >> 1;
                }
            }
            evenOrOdd = evenData % 2;

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

    public int getEvenOrOdd() {
        return evenOrOdd;
    }

    public int getEven() {
        return even;
    }
}
