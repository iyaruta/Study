package inheritance.e2;

import inheritance.Wolf;

import java.io.*;

/**
 * User: Alexandr
 * Date: 19.11.2014
 */
public class FileWriter extends Writer {

    private String path;

    public FileWriter(String path) {
        this.path = path;
    }

    @Override
    public void write(String s) {
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            raf.write(s.getBytes("Cp1251"));
            raf.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public String getPath() {
        return path;
    }

//    public void setPath(String path) {
//        this.path = path;
//    }
}
