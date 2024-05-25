package ru.itis.inf301;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        File outputPngFile = new File("Files/Logs/v19/v19.png");
        File fileDir = new File("Files/v19");
        String[] filenames = fileDir.list();
        MyThread[] array = new MyThread[filenames.length];
        for (int i = 0; i < filenames.length; i++) {
            array[i] = start("Files/v19/" + filenames[i]);
        }
        Arrays.stream(array).forEach(a -> a.start());
        Arrays.stream(array).forEach(a -> {
            try {
                a.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Arrays.sort(array, new Comparator<MyThread>() {
            @Override
            public int compare(MyThread o1, MyThread o2) {
                return o1.getPartNum() - o2.getPartNum();
            }
        });
        FileOutputStream os = new FileOutputStream(outputPngFile);
        for (int i = 0; i < filenames.length; ++i) {
            os.write(array[i].getData());
        }
        os.flush();
        os.close();
    }

    public static MyThread start(String filename) throws InterruptedException {
        MyThread thread = new MyThread(filename);
        return thread;
    }
}